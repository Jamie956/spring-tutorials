package com.jamie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class KController {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private Producer producer;

    @RequestMapping("/")
    public String hi() {
        return "hihi";
    }

    @RequestMapping("/send")
    public void send() {
        producer.send6();
    }
}
