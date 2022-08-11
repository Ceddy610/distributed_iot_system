package org.mqttToUdp;

import org.mqttToUdp.subscriber.Subscriber;

import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        Subscriber subscriber1 = new Subscriber("sensorData", false);
        Subscriber subscriber2 = new Subscriber("$SYS/broker/load/messages/sent/+", true);

        subscriber1.run();
        subscriber2.run();
    }
}