package org.httpserver;

public class Main {
    public static void main(String[] args) {


        HttpServer server = new HttpServer(8051);

        server.run();
    }
}