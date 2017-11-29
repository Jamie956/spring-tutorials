package com.example.demo.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiREST {

	@GetMapping("/rest/hi")
	public String sayHi() {
		return "Hello World!";
	}
	
	@GetMapping("/open")
	public String open() {
		return "all know";
	}
	
}
