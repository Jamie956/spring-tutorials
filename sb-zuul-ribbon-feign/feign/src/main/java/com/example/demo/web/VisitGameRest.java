package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.VisitGameService;

@RestController
public class VisitGameRest {

	@Autowired
	private VisitGameService visitGameService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String asYouLike() {
		return visitGameService.guest();
	}
	
}
