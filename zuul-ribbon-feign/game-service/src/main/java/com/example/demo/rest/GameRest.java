package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRest {

	@Value("${server.port}")
	private String port;

	@GetMapping("/")
	public String guest() {
		return "I like Dota2, from port: " + port;
	}
}
