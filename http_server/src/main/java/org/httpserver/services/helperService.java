package org.httpserver.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.httpserver.HttpServer;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class helperService {
    private static FileWriter file;

    private static double rttRPC;


    public static void writeStringToFile(String payload, String path) {
        JSONObject json = new JSONObject(payload);
        writeDataToFile(json,path);
    }

    public static void writeMapToFile(Map<String,Object> rttTCP, String path) {
        JSONObject json = new JSONObject(rttTCP);
        writeDataToFile(json,path);
    }


    public static void writeDataToFile(JSONObject json, String path) {
        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("." + path + ".json");
            file.write(json.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + json);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Float calculateTCPRTT(String sendTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSS");
        LocalDateTime newTime = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        System.out.println("Time-Now: " + newTime);
        System.out.println("Send-Time: " + sendTime);
        LocalDateTime oldTime = LocalDateTime.parse(sendTime, formatter);
        System.out.println("Time-Now: " + newTime + "Old-Time: " + oldTime);
        float time = newTime.getNano() - oldTime.getNano();
        time /= 1000000;
        return time;
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static double getRttRPC() {
        return helperService.rttRPC;
    }
    public static void setRttRPC(double rttRPC) {
        helperService.rttRPC = rttRPC;
    }
}
