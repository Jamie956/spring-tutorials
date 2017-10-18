package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SbStudentRestApplication {
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping(value = "/")
	public String welcome() {
		return "Welcome To Student Service on port : " + port;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SbStudentRestApplication.class, args);
	}
	
}
