package com.jamie;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Producer {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;
    public void send() {
        kafkaTemplate.send("test_topic", "this is content!");
    }
}
