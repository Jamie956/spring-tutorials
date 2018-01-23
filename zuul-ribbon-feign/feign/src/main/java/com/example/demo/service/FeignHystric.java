package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class FeignHystric implements VisitGameService {
	@Override
	public String guest() {
		return "Oop! not enough 18~, from feign";
	}
}
