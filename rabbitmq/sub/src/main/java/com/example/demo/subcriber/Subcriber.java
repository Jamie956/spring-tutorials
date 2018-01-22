package com.example.demo.subcriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Subcriber {

	@RabbitListener(queues="${rabbitmq.queue}")
    public void recievedMessage(String msg) {
        System.out.println("Recieved Message -> " + msg);
    }
}