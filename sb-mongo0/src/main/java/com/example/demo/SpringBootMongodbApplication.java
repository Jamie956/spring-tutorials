package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/configTest.properties")
public class SpringBootMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbApplication.class, args);
	}
}
