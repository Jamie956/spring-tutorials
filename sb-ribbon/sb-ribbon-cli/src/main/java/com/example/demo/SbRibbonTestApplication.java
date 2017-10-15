package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.example.demo.config.Configuration;


@SpringBootApplication
@RibbonClient(name = "asyoulike", configuration = Configuration.class)
public class SbRibbonTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbRibbonTestApplication.class, args);
	}
}
