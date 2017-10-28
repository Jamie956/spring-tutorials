package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiRest {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/")
	public String sayhi() {
		return "Hello World, I am from port:" +port;
	}
}
