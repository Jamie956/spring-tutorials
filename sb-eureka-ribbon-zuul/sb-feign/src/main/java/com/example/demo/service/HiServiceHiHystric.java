package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class HiServiceHiHystric implements HiService {
	@Override
	public String sayhi() {
		return "Oop! sorry~ from feign";
	}
}
