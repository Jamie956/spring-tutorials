package com.example.demo.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(String message) {
		amqpTemplate.convertAndSend("myexchange", "topic.message1", message);
	}
	
	public void onlySendToMessage2(String message) {
		amqpTemplate.convertAndSend("myexchange", "topic.message2", message);
	}
}