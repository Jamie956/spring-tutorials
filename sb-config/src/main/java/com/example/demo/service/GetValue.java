package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GetValue {
	@Value("${com.jamie.name}")
	private String name;

	public String getName() {
		return name;
	}
}
