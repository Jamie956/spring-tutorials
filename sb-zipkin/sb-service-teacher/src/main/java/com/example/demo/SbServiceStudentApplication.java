package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
	
	@RequestMapping("/")
	public String hi(){
		return "I am teacher!";
	}

	@RequestMapping("/get")
	public String info(){
		return restTemplate.getForObject("http://localhost:8082/response",String.class);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
