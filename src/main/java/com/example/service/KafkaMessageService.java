package com.example.service;

public interface KafkaMessageService {
    void sendKafkaMessage(String topic,String message);
}
