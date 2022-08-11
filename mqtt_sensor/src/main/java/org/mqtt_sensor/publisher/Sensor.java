package org.mqtt_sensor.publisher;

import java.util.concurrent.ThreadLocalRandom;

public class Sensor implements Runnable{

    private boolean running = true;
    SensorData data = new SensorData();
    Publisher publisher;


    public Sensor() {
    }

    @Override
    public void run() {
        while(running) {
            try {
                int randomNum = ThreadLocalRandom.current().nextInt(10, 50 + 1);
                this.data.setPressure(String.valueOf(randomNum));
                this.publisher = new Publisher(this.data);
                this.publisher.run();
            } catch (Exception e) {
                this.run();
            }

        }
    }

    public void stop() {
        this.running = false;
    }
}
