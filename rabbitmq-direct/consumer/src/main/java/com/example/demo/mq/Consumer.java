package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@RabbitListener(queues = "my-queue")
	public void processC(String message) {
		System.out.println("message: " + message);
	}
}