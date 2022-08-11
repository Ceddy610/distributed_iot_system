package org.iotgateway.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MeasureService{
    static int measurementsCounter = 0;

    static AtomicInteger packageLoss = new AtomicInteger();
    static AtomicReference<Float> rttSumCounter = new AtomicReference<>((float) 0);
    /**
     * Calculate Average RTT of requested and replied Packages
     * @return Float
     */
    public static double calcRTTAverage(Map<String,String> map) {
        final double[] rttSumValue = {0};
        double rttAverage = 0;

        map.forEach((packageId,timeString) -> {
            float time = 0;
            if (Objects.equals(timeString, null)) {
                packageLoss.getAndIncrement();
            } else {
                time = Float.parseFloat(timeString);
            }
            double finalTime = time;
            rttSumValue[0] = helperService.roundAvoid(rttSumValue[0] + finalTime, 5) ;
            rttSumCounter.getAndSet(rttSumCounter.get() + 1);
        });
        rttAverage = rttSumValue[0] / rttSumCounter.get();

        return helperService.roundAvoid(rttAverage, 5);
    }

    public static String calcRtt(String timeString) {
        float time = -1;
        if (!Objects.equals(timeString, null)) {
            time = Float.parseFloat(timeString);
        }
        return String.valueOf(time);
    }

    public static Map<String,Object> writeToMap(String sensor, double rttAverage, String rttCurrent , int frequency, int modForTCP, String mqttMessages) {
        Map<String, String> data = new HashMap<>();
        Map<String,Object> measurement = new HashMap<>();
        data.put("activeSensors", sensor);
        data.put("frequencyUdp", String.valueOf(frequency));
        data.put("frequencyTcp", String.valueOf(frequency));
        data.put("packageLossUdp", String.valueOf(packageLoss.get()));
        data.put("sentPackagesUdp", String.valueOf(rttSumCounter.get()));
        data.put("rttUdp", rttCurrent);
        data.put("rttUdpAverage", String.valueOf(rttAverage));
        data.put("mqttMessages", mqttMessages);


        measurement.put(String.valueOf(measurementsCounter++), data);
        return measurement;
    }
}
