package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerRest {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/")
	public String go() {
		return "Beer, it's good for you ps: message from port : " +port;
	}
}
