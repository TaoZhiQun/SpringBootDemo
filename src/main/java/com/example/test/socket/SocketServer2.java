package com.example.test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer2 {
    public static void main(String[] args) {
        int port = 1234;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            final ExecutorService executorService = Executors.newFixedThreadPool(100);
            while (true) {
                final Socket socket = serverSocket.accept();
                Runnable runnable = () -> {
                    try {
                        final InputStream inputStream = socket.getInputStream();
                        byte[] bytes = new byte[1024];
                        int len;
                        StringBuilder sb = new StringBuilder();
                        while ((len = inputStream.read(bytes)) != -1) {
                            sb.append(new String(bytes, 0, len, "UTF-8"));
                        }
                        System.out.println("收到报文" + sb.toString());
                        inputStream.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                executorService.submit(runnable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
