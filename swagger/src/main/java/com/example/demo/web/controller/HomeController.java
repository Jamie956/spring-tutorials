package com.example.demo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HomeController {
	@ApiIgnore
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "Welcome!";
	}
}