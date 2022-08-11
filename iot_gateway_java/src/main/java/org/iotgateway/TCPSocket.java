package org.iotgateway;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.iotgateway.data.sensorData;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

public class TCPSocket{

    private static InetAddress addr;

    private static Socket socket;

    private final boolean autoflush = true;
    private static PrintWriter out;
    public TCPSocket() throws IOException {
        addr = InetAddress.getByName("httpserver");
        socket = new Socket(addr, 8051);
        out = new PrintWriter(socket.getOutputStream(), autoflush);
    }


    public void sendSensorData(sensorData data) throws IOException {
        LocalDateTime time = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        ObjectMapper obj = new ObjectMapper();
        String request = "POST " + "/sensorData" + " HTTP/1.0\r\n" + "Accept: */*\r\n"
                + "Host: " + "localhost:8051" + "\r\n"
                + "Created-At: " + time + "\r\n"
                + "Access-Control-Allow-Origin: *" + "\r\n"
                + "Access-Control-Allow-Credentials: " + "true" + "\r\n"
                + "Access-Control-Expose-Headers: " + "Created-At" + "\r\n"
                + "Content-Type: application/json\r\n"
                + "Content-Length: " + obj.writeValueAsString(data).getBytes().length + "\r\n\r\n" + obj.writeValueAsString(data);
        out.write(request);
        out.flush();
    }

    public void sendRttValues(Map<String, Object> rtt) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        LocalDateTime time = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        System.out.println(obj.writeValueAsString(rtt));
        String request = "POST " + "/rtt" + " HTTP/1.0\r\n" + "Accept: */*\r\n"
                + "Host: " + "localhost:8051" + "\r\n"
                + "Created-At: " + time + "\r\n"
                + "Access-Control-Allow-Origin: *" + "\r\n"
                + "Access-Control-Allow-Credentials: " + "true" + "\r\n"
                + "Access-Control-Expose-Headers: " + "Created-At" + "\r\n"
                + "Content-Type: application/json\r\n"
                + "Content-Length: " + obj.writeValueAsString(rtt).getBytes().length + "\r\n\r\n" + obj.writeValueAsString(rtt);
        out.write(request);
        out.flush();
    }
}
