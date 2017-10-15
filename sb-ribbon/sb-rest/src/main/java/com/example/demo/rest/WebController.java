package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@Value("${server.port}")
	String port;

	@RequestMapping(value = "/")
	public String home() {
		return "home!";
	}

	@RequestMapping("/greeting")
	public String hello() {
		return "port -> " + port ;
	}
}