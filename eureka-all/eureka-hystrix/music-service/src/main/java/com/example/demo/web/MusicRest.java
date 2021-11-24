package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicRest {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/")
	public String listen() {
		return "Enjoy music from port: " +port;
	}
}
