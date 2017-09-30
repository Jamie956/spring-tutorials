package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user) {
    	userService.saveUser(user);
    }
}