package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiRest {
	@Value("${foo}")
	private String foo;

	@Value("${bar}")
	private String bar;

	@RequestMapping(value = "/")
	public String get() {
		return foo + "; " + bar;
	}
}
