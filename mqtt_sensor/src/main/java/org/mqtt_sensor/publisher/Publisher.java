package org.mqtt_sensor.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher implements Runnable {

    String broker;

    String topic;

    SensorData data;

    ObjectMapper mapper;



    public Publisher(SensorData data) {
        this.broker = "tcp://0.0.0.0:1883";
        this.topic = "sensorData";
        this.data = data;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void run() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);

        try{
            MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
            client.connect(options);

            MqttMessage message = new MqttMessage(this.mapper.writeValueAsString(this.data).getBytes());
            message.setQos(2);

            client.publish(this.topic, message);

            client.disconnect();

        }catch (MqttException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
