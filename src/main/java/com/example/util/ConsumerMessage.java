package com.example.util;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Rabbitmq 消费端
 * @author Tao
 */
public class ConsumerMessage {
    private static final String QUEUE_NAME ="胡康康的第一条队列";
    private static final String IP_ADDRESS = "106.14.119.3";
    private static final int PORT = 5672;
    private static Address[] addresses =new Address[]{new Address(IP_ADDRESS,PORT)};
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection connection = connectionFactory.newConnection(addresses);
        Channel channel = connection.createChannel();
        channel.basicQos(64);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("-----接收消息-----"+new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,consumer);
        try {
            TimeUnit.SECONDS.sleep(2);
            channel.close();
            connection.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
