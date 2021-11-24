package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToolRest {

	@Value("${server.port}")
	private String port;

	@GetMapping("/")
	public String call() {
		return "Guitar, from port: " + port;
	}
}
