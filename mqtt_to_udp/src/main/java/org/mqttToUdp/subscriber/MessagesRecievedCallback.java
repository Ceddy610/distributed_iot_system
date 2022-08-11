package org.mqttToUdp.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.mqttToUdp.UDPSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

public class MessagesRecievedCallback implements MqttCallback {

    Logger LOGGER = LoggerFactory.getLogger(MessagesRecievedCallback.class);

    UDPSocket socket;

    ObjectMapper mapper;

    public MessagesRecievedCallback(UDPSocket socket) throws UnknownHostException {
        this.mapper = new ObjectMapper();
        this.socket = socket;

    }


    @Override
    public void connectionLost(Throwable throwable) {
        LOGGER.error("Connection to MQTT broker lost!");

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        LOGGER.info("Message received: "+ new String(mqttMessage.getPayload()) );
        messagesModel messages = new messagesModel();
        messages.setMessages(new String(mqttMessage.getPayload()));
        socket.sendMessage(this.mapper.writeValueAsString(messages).getBytes());
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
