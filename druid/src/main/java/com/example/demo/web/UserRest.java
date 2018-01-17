package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserRest {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@RequestBody User u) {
		userService.save(u);
		return "done";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		List<User> us = userService.findAll();
		return us;
	}
	
}
