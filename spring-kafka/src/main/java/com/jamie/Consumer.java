package com.jamie;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
//    @KafkaListener(topics = {"test_topic"})
//    public void receive(String message){
//        System.out.println("消费消息:" + message);
//    }

    @KafkaListener(topics = {"test_topic"})
    public void onMessage1(ConsumerRecord<?, ?> record) {
        System.out.println("topic: " + record.topic() + "    partition: " + record.partition() + "     value: " + record.value());
    }
}