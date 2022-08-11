package org.mqttToUdp.subscriber;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.mqttToUdp.UDPSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MqttToTcpCallback  implements MqttCallback {

    Logger LOGGER = LoggerFactory.getLogger(MqttToTcpCallback.class);

    InetAddress address = InetAddress.getByName("0.0.0.0");

    int port = 8008;

    UDPSocket socket;


    public MqttToTcpCallback(UDPSocket socket) throws UnknownHostException {
        this.socket = socket;
    }


    @Override
    public void connectionLost(Throwable throwable) {
        LOGGER.error("Connection to MQTT broker lost!");

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        LOGGER.info("Message received: "+ new String(mqttMessage.getPayload()));
        socket.sendMessage(mqttMessage.getPayload());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        try {
            LOGGER.info("Delivery completed: "+ iMqttDeliveryToken.getMessage() );
        } catch (MqttException e) {
            LOGGER.error("Failed to get delivery token message: " + e.getMessage());
        }

    }

}
