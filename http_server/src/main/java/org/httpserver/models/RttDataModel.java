package org.httpserver.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RttDataModel {
    String activeSensors;
    String frequency;
    String rttUdpAverage;
    String rttTcpAverage;
}
