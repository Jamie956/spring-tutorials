package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@RabbitListener(queues = "fanout.A")
	public void processA(String message) {
		System.out.println("ReceiveA: " + message);
	}

	@RabbitListener(queues = "fanout.B")
	public void processB(String message) {
		System.out.println("ReceiveB: " + message);
	}

	@RabbitListener(queues = "fanout.C")
	public void processC(String message) {
		System.out.println("ReceiveC: " + message);
	}
}