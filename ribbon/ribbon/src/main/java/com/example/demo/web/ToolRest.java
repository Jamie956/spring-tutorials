package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ToolRest {
	
	@LoadBalanced
	@Bean
	private RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String call() {
		return this.restTemplate.getForObject("http://tool-service", String.class);
	}
}