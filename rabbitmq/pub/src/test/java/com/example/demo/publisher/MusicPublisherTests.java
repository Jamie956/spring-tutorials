package com.example.demo.publisher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.publisher.MusicPublisher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicPublisherTests {

	@Autowired
	MusicPublisher musicPublisher;
	
	@Test
	public void testpub() {
		musicPublisher.loadMusic("the sound of silence");
		musicPublisher.loadMusic("new soul");
	}
}
