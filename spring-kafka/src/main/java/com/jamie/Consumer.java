package com.jamie;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = {"test_topic"})
    public void receive(String message){
        System.out.println("消费消息:" + message);
    }
}