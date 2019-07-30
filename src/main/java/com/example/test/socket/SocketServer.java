package com.example.test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        int port = 1234;
        try {
            final ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            final InputStream inputStream = socket.getInputStream();
            byte[] bytes;
            while (true) {
                int first = inputStream.read();
                if (first == -1) {
                    break;
                }
                int second = inputStream.read();
                int length = (first << 8) + second;
                System.out.println("first长度"+first+"second长度"+second);
                System.out.println("length长度"+length);
                bytes = new byte[length];
                inputStream.read(bytes);
                System.out.println("get message from client:" + new String(bytes, "UTF-8"));
            }
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
