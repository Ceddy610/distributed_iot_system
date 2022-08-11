package org.iotgateway.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.iotgateway.data.MqttMessages;
import org.iotgateway.data.PressureData;
import org.iotgateway.data.ReplyData;
import org.iotgateway.data.SendRequest;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.NANOS;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class helperService {

    public static String convertToJson(SendRequest item) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        return obj.writeValueAsString(item);
    }


    public static ReplyData convertFromJson(String json) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        return obj.readValue(json, ReplyData.class);
    }

    public static PressureData convertPressure(String json) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        return obj.readValue(json, PressureData.class);
    }

    public static MqttMessages convertMessages(String json) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        return obj.readValue(json, MqttMessages.class);
    }


    public static String measureTime(ReplyData replies, int frequency) {

        LocalTime localTime = LocalTime.now();
        LocalTime time = LocalTime.parse(replies.getTime());

        double measuredTime = roundAvoid(((double) NANOS.between(time, localTime)/1000000)-frequency*2, 5);

        if (measuredTime < 0) {
            return String.valueOf(-1);
        }

        return String.valueOf(measuredTime);
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static void writeToFile(Map<String,String> map, String sensor) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            map.put("activeSensors", sensor);
            objectMapper.writeValue(new File("./rtt.json"),map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int indexSelector(List<Integer> addresses) {
        return (int) (Math.random() * ((addresses.size())));

    }
        
}
