package com.example.demo.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicRest {
	@GetMapping("/rest/listen")
	public String listenMusic() {
		return "Just enjoy New Age.";
	}
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to concert.";
	}
}
