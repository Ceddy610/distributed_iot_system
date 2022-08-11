package org.httpserver.models;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SensorDataModel {
    String temperature;
    String sundensity;
    String humidity;
    String pressure;
}
