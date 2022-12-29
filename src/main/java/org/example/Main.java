package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    static final String[] MESSAGES = {
            "Hello world!",
            "This is a test message.",
            "This is a longer test message.",
    };

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(0)) {
            System.out.println("Listening on port: " + serverSocket.getLocalPort());
            while (true) {
                Socket socket = serverSocket.accept();
                handle(socket);
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handle(Socket socket) {
        System.out.println("New Connection from: " + socket.getInetAddress());
        String message = MESSAGES[(int) (Math.random() * MESSAGES.length)];
        try{
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
