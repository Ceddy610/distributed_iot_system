package org.mqtt_sensor;

import org.mqtt_sensor.publisher.Sensor;

public class Main {
    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        sensor.run();
    }
}