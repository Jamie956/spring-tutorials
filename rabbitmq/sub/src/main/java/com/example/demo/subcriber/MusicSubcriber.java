package com.example.demo.subcriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MusicSubcriber {

	@RabbitListener(queues = "${rabbitmq.queue}")
	public void listenMusic(String music) {
		System.out.println("Listen to music: "+music);
	}
}