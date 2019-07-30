package com.example.test.socket;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 1234;
        try {
            Socket socket = new Socket(host, port);
            final OutputStream outputStream = socket.getOutputStream();
            String message = "Hello Tao";
            byte[] sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >> 8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);
            outputStream.flush();

            message = "second message";
            sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >> 8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
