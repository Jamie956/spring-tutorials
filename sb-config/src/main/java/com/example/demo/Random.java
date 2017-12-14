package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Random {
	@Value("${com.jamie.name}")
    private String name;
	
	public void hi() {
		System.out.println("***hi***");
		System.out.println("==="+name+"===");
	}
}
