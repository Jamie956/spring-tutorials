package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class goMusic {
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/")
	public String listenToRap() {
		return "Stan said I x you from port : " +port;
	}
}
