package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@RabbitListener(queues = "topic.message1")
	public void process1(String message) {
		System.out.println("message1: " + message);
	}

	@RabbitListener(queues = "topic.message2")
	public void process2(String message) {
		System.out.println("message2: " + message);
	}
}
