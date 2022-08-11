package org.httpserver;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.httpserver.models.SensorDataModel;
import org.httpserver.models.SensorDataModelResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.rpc.Database;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.NANOS;
import static org.httpserver.services.helperService.*;

public class ClientHandler extends Thread {

    Socket client;

    InputStream is;

    RPCClient rpcClient1;

    RPCClient rpcClient2;

    LocalTime rpcTimeStart;

    double rttRPC;

    Map<String,Object> rttTCP;

    int packageLossTcp;

    ObjectMapper mapper = new ObjectMapper();

    ObjectMapper requestJson = new ObjectMapper();

    public ClientHandler(Socket client) {
        this.client = client;
        try {
            this.is = client.getInputStream();
            this.rttTCP = new HashMap<>();
            this.rpcClient1 = new RPCClient(9091, "rpcserver1");
            this.rpcClient2 = new RPCClient(9092, "rpcserver2");
            this.rttRPC = 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        try {
            Map<String, String> map = readRequest(bufferedReader);
            if(Objects.equals(map.get("method"), "GET")) {
                String accessLog = String.format("Client %s, method %s, path %s, version %s, host %s",
                        client, map.get("method"), map.get("path"), map.get("version"), map.get("host"));
                //System.out.println(accessLog);
            } else if(Objects.equals(map.get("method"), "POST")) {
                String accessLog = String.format("Client %s, method %s, path %s, version %s, host %s",
                        client, map.get("method"), map.get("path"), map.get("version"), map.get("host"));
                //System.out.println(accessLog);
            }

            if(Objects.equals(map.get("method"), "GET")) {
                if(Objects.equals(map.get("path"), "/sensorData-db")){
                    try {
                        requestJson.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                        this.rpcTimeStart = LocalTime.now();
                        Database.sensorDataResponse request = null;
                        if(!this.rpcClient1.channel.isTerminated()){
                            request = this.rpcClient1.getSensorData();
                        }
                        if(!this.rpcClient2.channel.isTerminated()){
                            request = this.rpcClient2.getSensorData();
                        }
                        SensorDataModelResponse response = new SensorDataModelResponse();
                        assert request != null;
                        response.setHumidity(request.getHumidity());
                            response.setDate(request.getDate());
                            response.setSundensity(request.getSundensity());
                            response.setTemperature(request.getTemperature());
                            if(!request.getPressure().equals("")) response.setPressure(request.getPressure());
                        byte[] responseJson = requestJson.writeValueAsString(response).getBytes();
                            sendGetResponse(client, "200 OK", "text/plain", responseJson);
                            LocalTime currentTime = LocalTime.now();
                            setRttRPC(roundAvoid((double) NANOS.between(this.rpcTimeStart, currentTime)/1000000, 5));
                            System.out.println("-------------------------------------------");
                            System.out.printf("Starting Time: %s", this.rpcTimeStart);
                            System.out.printf("End Time: %s", currentTime);
                            System.out.printf("rttRPC: %s", this.rttRPC);
                            System.out.println("-------------------------------------------");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    Path filePath = getFilePath(map.get("path"));
                    if (Files.exists(filePath)) {
                        // file exist
                        String contentType;
                        try {
                            contentType = ContentType(filePath);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            sendGetResponse(client, "200 OK", contentType, Files.readAllBytes(filePath));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 404
                        byte[] noFoundContent = "<h1>Not found :(</h1>".getBytes();
                        try {
                            sendGetResponse(client, "404 Not Found", "text/html", noFoundContent);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                //POST METHOD FOR SERVER (IF GATEWAY SENDS A POST, THE SERVER SAVES IT)
            } else if(Objects.equals(map.get("method"), "POST")) {
                System.out.println("!!!!!!! POST Path: " + map.get("path") + " !!!!!!!!");
                if (Objects.equals(map.get("path"), "/rtt")) {
                    JSONObject json = new JSONObject(map.get("content"));
                    System.out.println("json: " + json);
                    Map<String, Object> jsonMap = json.toMap();
                    Map<String, String> data = new HashMap<>();
                    System.out.println(map);
                    String sendTime = map.get("Created-At");
                    for (Map.Entry<String, Object> jsonMapEntry : jsonMap.entrySet()) {
                        Object jsonMapObject = jsonMapEntry.getValue();
                        if (jsonMapObject instanceof Map) {
                            Map<?, ?> dataOfJsonMap = (Map) (jsonMapObject);
                            for (Map.Entry<?, ?> dataEntry : dataOfJsonMap.entrySet()) {
                                String key = dataEntry.getKey().toString();
                                String value = dataEntry.getValue().toString();
                                data.put(key, value);
                            }
                        }
                        float currentRtt = calculateTCPRTT(sendTime);
                        if(currentRtt < 0) {
                            packageLossTcp++;
                            data.put("rttTCP", String.valueOf(0));
                        } else {
                            data.put("rttTCP", String.valueOf(currentRtt * 2));
                        }
                        /*if(rttRPC < 0) {
                            data.put("rttRPC", String.valueOf(0));
                        } else {*/
                            data.put("rttRPC", String.valueOf(getRttRPC()));
                        System.out.println("----------------------SEND---------------------");
                        System.out.printf("rttRPC: %s", this.rttRPC);
                        System.out.println("-------------------------------------------");
                        //}
                        data.put("packageLossTcp", String.valueOf(packageLossTcp));
                        rttTCP.put(jsonMapEntry.getKey(), data);
                    }
                    writeMapToFile(rttTCP,map.get("path"));
                } else {
                    writeStringToFile(map.get("content"),map.get("path"));
                    System.out.println(LocalDateTime.now());
                    if(!this.rpcClient1.channel.isTerminated() && !this.rpcClient2.channel.isTerminated()) {
                        this.rpcClient1.sendSensorData(mapper.readValue(map.get("content"), SensorDataModel.class));
                        this.rpcClient2.sendSensorData(mapper.readValue(map.get("content"), SensorDataModel.class));
                    }
                }
                try {
                    sendPostResponse(client, "200 OK", "application/json");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        //GET METHOD FOR BROWSER

    }

    private static void sendGetResponse(Socket client, String status, String contentType, byte[] content) throws IOException {
        LocalDateTime time = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        OutputStream clientOutput = client.getOutputStream();
        clientOutput.write(("HTTP/1.1 \r\n" + status).getBytes());
        clientOutput.write(("ContentType: " + contentType + "\r\n").getBytes());
        clientOutput.write(("Created-At: " + time + "\r\n").getBytes());
        clientOutput.write(("Access-Control-Allow-Origin: *" + "\r\n").getBytes());
        clientOutput.write(("Access-Control-Allow-Credentials: " + "true" + "\r\n").getBytes());
        clientOutput.write(("Access-Control-Expose-Headers: " + "Created-At" + "\r\n").getBytes());
        clientOutput.write("\r\n".getBytes());
        clientOutput.write(content);
        clientOutput.write("\r\n\r\n".getBytes());
        clientOutput.flush();
        client.close();
    }

    private static void sendPostResponse(Socket client, String status, String contentType) throws IOException {
        OutputStream clientOutput = client.getOutputStream();
        clientOutput.write(("HTTP/1.1 \r\n" + status).getBytes());
        clientOutput.write(("ContentType: " + contentType + "\r\n").getBytes());
        clientOutput.write("\r\n".getBytes());
        clientOutput.write("\r\n\r\n".getBytes());
        clientOutput.flush();
        client.close();
    }

    private static Path getFilePath(String path) {
        if ("/".equals(path)) {
            path = "/index.html";
        }

        //System.out.println(path + ".json");
        return Paths.get(path + ".json");
    }

    private static String ContentType(Path filePath) throws IOException {
        return Files.probeContentType(filePath);
    }

    private Map<String, String> readRequest(BufferedReader reader) throws IOException {
        Map<String, String> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()).length() != 0) {
            builder.append(line).append("\r\n");
        }
        String request = builder.toString();

        //System.out.println(request);

        String requestLoad = builder.toString();
        String[] requestsLines = requestLoad.split("\r\n");
        String[] requestLine = requestsLines[0].split(" ");
        map.put("method", requestLine[0]);
        map.put("path", requestLine[1]);
        map.put("version", requestLine[2]);
        map.put("host", requestsLines[1].split(" ")[1]);
        map.put("Created-At", requestsLines[3].split(" ")[1]);
        if(Objects.equals(requestLine[0], "POST")) {
            builder.setLength(0);
            line ="";
            while (reader.ready()) {
                    //System.out.println(line);
                    builder.append((char) reader.read());
                }
            String content = builder.toString();
            //System.out.println(content);
            map.put("content", content);
            }
        return map;
    }
}
