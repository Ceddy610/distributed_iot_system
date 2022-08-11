package org.mqttToUdp;

import java.io.IOException;
import java.net.*;

public class UDPSocket {

    InetAddress address = InetAddress.getByName("0.0.0.0");

    int port = 8008;

    byte[] buf;

    DatagramSocket socket;

    public UDPSocket() throws UnknownHostException, SocketException {
        this.buf = new byte[4096];
        this.socket = new DatagramSocket();
    }

    public void sendMessage(byte[] payload) throws IOException {
        DatagramPacket mqttMessage = new DatagramPacket(payload, payload.length, address, port);
        socket.send(mqttMessage);

    }
}
