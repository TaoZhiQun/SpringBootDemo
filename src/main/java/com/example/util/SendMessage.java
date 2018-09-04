package com.example.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendMessage {
    private final static String QUEUE_NAME = "hello.august";
    public static void main(String[] args) {
        ConnectionFactory connectionFactory  = new ConnectionFactory();
        connectionFactory.setHost("192.168.101.145");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message ="hello world";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("-------------------send message--------------------"+message);
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
