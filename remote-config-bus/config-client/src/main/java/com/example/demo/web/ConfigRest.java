package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigRest {
	@Value("${foo}")
	private String foo;
	@Value("${bar}")
	private String bar;
	@Value("${myport}")
	private String myport;
	@Value("${msg}")
	private String msg;
	@Value("${my.design.msg}")
	private String msg2;
	
	@RequestMapping(value = "/")
	public String get() {
		return "foo => " + foo + ";\n" + "bar => " + bar;
	}
	@RequestMapping(value = "/myport")
	public String getPort() {
		return "myport => " + myport;
	}
	@RequestMapping(value = "/msg")
	public String getMsg() {
		return "msg => " + msg;
	}
	@RequestMapping(value = "/msg2")
	public String getMsg2() {
		return "msg2 => " + msg2;
	}
}
