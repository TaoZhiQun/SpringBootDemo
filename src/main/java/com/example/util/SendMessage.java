package com.example.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Rabbitmq 生产数据端
 * @author Tao
 */
public class SendMessage {
    private final static String EXCHANGE_NAME = "exchange_trade";
    private static final String ROUTING_KEY = "rontingkey_trade";
    private static final String QUEUE_NAME ="胡康康的第一条队列";
    private static final String IP_ADDRESS = "106.14.119.3";
    public static void main(String[] args) {
        ConnectionFactory connectionFactory  = new ConnectionFactory();
        connectionFactory.setHost(IP_ADDRESS);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME,"direct",true,false,null);
            channel.queueDeclare(QUEUE_NAME,true,false,false,null);
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTING_KEY);
            String message ="hello world";
            channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
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
