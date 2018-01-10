package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HiRest {
	@Value("${foo}")
	private String foo;

	@Value("${bar}")
	private String bar;

	@RequestMapping(value = "/")
	public String get() {
		return "foo => " + foo + ";\n" + "bar => " + bar;
	}
}
