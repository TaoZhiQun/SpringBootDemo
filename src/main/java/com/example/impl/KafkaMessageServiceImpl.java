package com.example.impl;

import com.example.service.KafkaMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service(value = "kafkaMessageService")
public class KafkaMessageServiceImpl implements KafkaMessageService {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Override
    public void sendKafkaMessage(String topic, String message) {
        kafkaTemplate.send(topic,message);
    }
}
