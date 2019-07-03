package com.example.message;

import com.example.impl.UserServiceImpl;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

// @Component
public class KafkaLisener {
    private static final Logger logger = LoggerFactory.getLogger(KafkaLisener.class);
    @KafkaListener(topics = "test")
    public void receive(ConsumerRecord<?, ?> consumer) {
        logger.info("{} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
    }
}
