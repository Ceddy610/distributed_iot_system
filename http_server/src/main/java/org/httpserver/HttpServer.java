package org.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class HttpServer implements Runnable {

    int port;
    volatile boolean active = true;


    public HttpServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket socket = new ServerSocket(port)) {
            while (active) {
                Socket client = socket.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                clientHandler.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
