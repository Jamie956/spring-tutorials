package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.JwtUser;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JwtUser login(@RequestBody JwtUser jwtuser) {
		
		JwtUser jwtUser= loginService.login(jwtuser);
		return jwtUser;
	}
	

}
