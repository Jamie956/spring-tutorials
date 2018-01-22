package com.example.demo.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	@Autowired
	private AmqpTemplate ampqTemplate;

	@Value("${custom.rabbit.queue.name}")
	private String queueName;

	public void send(String message) {
		ampqTemplate.convertAndSend(queueName, message);
	}
}
