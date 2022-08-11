package org.mqttToUdp.subscriber;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.mqttToUdp.UDPSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketException;
import java.net.UnknownHostException;


public class Subscriber implements Runnable {

    String broker;

    String topic;

    boolean messages;

    UDPSocket socket1;

    UDPSocket socket2;


    Logger LOGGER = LoggerFactory.getLogger(Subscriber.class);


    public Subscriber(String topic, boolean messages) throws UnknownHostException, SocketException {
        this.broker = "tcp://0.0.0.0:1883";
        this.topic = topic;
        this.messages = messages;
        this.socket1 = new UDPSocket();
        this.socket2 = new UDPSocket();
    }

    @Override
    public void run() {
        try {
            MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
            if(this.messages) {
                client.setCallback(new MessagesRecievedCallback(this.socket1));
            } else {
                client.setCallback(new MqttToTcpCallback(this.socket2));
            }

            client.connect();


            LOGGER.info("Connected to MQTT broker: " + client.getServerURI());

            client.subscribe(this.topic);
            LOGGER.info("Subscribed to: " + this.topic);
        } catch (MqttException | UnknownHostException e) {
            this.run();
        }

    }
}
