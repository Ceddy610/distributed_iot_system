package org.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.service.sensorDataService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(Integer.parseInt(args[0])).addService(new sensorDataService()).build();

        server.start();

        System.out.println("Server started on " + server.getPort());

        server.awaitTermination();
    }
}