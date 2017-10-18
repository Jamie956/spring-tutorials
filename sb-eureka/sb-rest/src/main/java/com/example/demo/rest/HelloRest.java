package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {
	@GetMapping("/hello")
	public String hi() {
		return "hello world";
	}
}
