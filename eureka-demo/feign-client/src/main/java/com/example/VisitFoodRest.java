package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitFoodRest {

	@Autowired
	private CallRemoteService callRemoteService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hi() {
		return callRemoteService.hi();
	}
}
