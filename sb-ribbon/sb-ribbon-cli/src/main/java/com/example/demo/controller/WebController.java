package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {
	
	@LoadBalanced
	@Bean
	private RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String hello() {
		return this.restTemplate.getForObject("http://servise-hi", String.class);
	}
	
	@RequestMapping("/yo")
	public String yo() {
		return this.restTemplate.getForObject("http://servise-hi/yo", String.class);
	}
	
}