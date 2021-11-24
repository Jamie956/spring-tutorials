package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentRest {
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/")
	public String whoIAm(){
		return "I am student!";
	}
	
	@RequestMapping("/toteacher")
	public String sendToTeacher(){
		return restTemplate.getForObject("http://localhost:8083/fromstudent", String.class);
	}
	
	@RequestMapping("/tostudent")
	public String receiveFromTeacher(){
		return "Student receive teacher respond!";
	}

	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
