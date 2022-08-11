package org.httpserver.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDataModelResponse {
    String date;
    String temperature;
    String sundensity;
    String humidity;
    String pressure;
}
