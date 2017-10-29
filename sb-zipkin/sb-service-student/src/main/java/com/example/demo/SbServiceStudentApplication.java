package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SbServiceStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbServiceStudentApplication.class, args);
	}
	
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/")
	public String hi(){
		return "I am student!";
	}
	
	@RequestMapping("/send")
	public String send(){
		return restTemplate.getForObject("http://localhost:8083/get", String.class);
	}
	
	@RequestMapping("/response")
	public String info(){
		return "Got it!";

	}

	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
