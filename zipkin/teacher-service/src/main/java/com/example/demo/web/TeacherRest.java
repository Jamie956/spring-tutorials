package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TeacherRest {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String whoIAm(){
		return "I am teacher!";
	}

	@RequestMapping("/fromstudent")
	public String receiveFromStudent(){
		return restTemplate.getForObject("http://localhost:8082/tostudent",String.class);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
