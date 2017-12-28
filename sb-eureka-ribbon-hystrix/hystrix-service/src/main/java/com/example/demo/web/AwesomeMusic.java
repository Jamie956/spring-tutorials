package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Yo;

@RestController
public class AwesomeMusic {

	@Autowired
	private Yo yo;

	@RequestMapping(value = "/")
	public String run() {
		return yo.startUp();
	}

}
