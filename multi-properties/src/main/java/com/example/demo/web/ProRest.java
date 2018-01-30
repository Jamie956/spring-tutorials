package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProRest {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/")
	public String showPort() {
		return "Come from: "+port;
	}
}
