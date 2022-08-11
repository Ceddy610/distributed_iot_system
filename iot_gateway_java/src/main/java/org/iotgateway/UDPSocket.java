package org.iotgateway;


import org.iotgateway.data.*;
import org.iotgateway.services.MeasureService;
import org.iotgateway.services.helperService;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class UDPSocket implements Runnable {


    private final byte[] buf;
    private boolean running = true;
    List<Integer> addresses = new ArrayList<>();
    Map<String, String> rtt = new HashMap<>();

    private boolean sendPackage = true;

    String rttCurrent;

    private MqttMessages mqttMessages;

    List<ReplyData> data = new ArrayList<>();

    private PressureData mqttBuffer;

    int frequency = 10;
    int modForRTT = 20;

    TCPSocket socket;



    public UDPSocket() {
        buf = new byte[4096];

    }




    public void run() {

            System.out.println("IOT-Gateway is starting...");


        try ( DatagramSocket udpSocket = new DatagramSocket(8008) ) {

            while (running) {
                //revive message
                DatagramPacket udpPacket = new DatagramPacket(buf, buf.length);
                udpSocket.receive(udpPacket);
                handleSensor(udpPacket);

                TimeUnit.MILLISECONDS.sleep(frequency);

                //reply message
                if(sendPackage) {
                    SendRequest sendRequest = new SendRequest("getData");
                    byte[] sendPackage = helperService.convertToJson(sendRequest).getBytes();
                    //System.out.println(Arrays.toString(sendPackage));
                    DatagramPacket sendPacket = new DatagramPacket(sendPackage, sendPackage.length, udpPacket.getAddress(), addresses.get(helperService.indexSelector(addresses)));
                    udpSocket.send(sendPacket);
                    rtt.put(sendRequest.getUuid(), null);
                    System.out.println("Sent Packet");

                    if((rtt.size()%modForRTT) == 1) {
                        double rttAverage = MeasureService.calcRTTAverage(rtt);

                        try {
                            socket = new TCPSocket();
                        }catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        if(this.mqttMessages != null) {
                            socket.sendRttValues(MeasureService.writeToMap(String.valueOf(addresses.size()), rttAverage, rttCurrent, frequency, modForRTT, this.mqttMessages.getmqttMessages()));
                        } else {
                            socket.sendRttValues(MeasureService.writeToMap(String.valueOf(addresses.size()), rttAverage, rttCurrent, frequency, modForRTT, "offline"));
                        }
                    }

                }






            }
        } catch (SocketException e) {
            System.out.println("Could not start the UDP socket server.\n" + e);
        } catch (IOException e) {
            System.out.println("Invalid value given\n" + e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @SuppressWarnings("unused")
    public void stop() {
        this.running = false;
    }

    private void handleSensor(DatagramPacket udpPacket) throws IOException {

        try {
            socket = new TCPSocket();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        int port = udpPacket.getPort();

        int length = udpPacket.getLength();

        byte[] payload = Arrays.copyOfRange(udpPacket.getData(), 0, length);

        System.out.println("Message from: " + udpPacket.getAddress() + ":" + port + "\nMessage: " + new String(payload));

        if(new String(payload).equals("Sensor Startup")){
            addresses.add(port);
        } else if (new String(payload).equals("Shutdown Sensor")) {
            System.out.println("Sensor dead" + port);
            addresses.remove(port);
        } else if (new String(payload).contains("pressure")) {
            this.mqttBuffer = new PressureData();
            this.mqttBuffer = helperService.convertPressure(new String(payload));
            this.sendPackage = false;

        } else if (new String(payload).contains("messages")) {;
            this.mqttMessages = new MqttMessages();
            this.mqttMessages = helperService.convertMessages(new String(payload));
            this.sendPackage = false;
        }
        else {
            ReplyData newObject = helperService.convertFromJson(new String(payload));
            sensorData newData = newObject.getSensorData();
            if(rtt.containsKey(newObject.getUuid())) {
                rttCurrent = helperService.measureTime(newObject,frequency);
                System.out.println("Current Rtt String" + rttCurrent);
                rtt.put(newObject.getUuid(), rttCurrent);
            }
            if(this.mqttBuffer != null) {
                newData.setPressure(this.mqttBuffer.getPressure());
            } else {
                newData.setPressure("offline");
            }

            socket.sendSensorData(newData);
            data.add(newObject);
            this.sendPackage = true;

        }

    }





}
