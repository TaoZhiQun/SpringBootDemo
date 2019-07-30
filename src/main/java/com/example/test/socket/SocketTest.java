package com.example.test.socket;

import java.io.IOException;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) {
        Socket socket = null;
        byte[] bytes = new byte[1024];
        bytes = "Hello World".getBytes();
        try {
            socket = new Socket("192.168.33.111",1234);
            socket.setSoTimeout(5000);
            socket.getOutputStream().write(bytes);
            socket.getOutputStream().flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
