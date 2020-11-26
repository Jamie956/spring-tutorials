package com.jamie;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Greet {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("/")
    public String hi() {
        return "hihi";
    }

    @RequestMapping("/send")
    public void send() {
        kafkaTemplate.send("test_topic", "this is content");
    }
}
