package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.JwtUser;
import com.example.demo.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {
	@Autowired
	private JwtGenerator jwtGenerator;

	@PostMapping
	public String generate(@RequestBody final JwtUser jwtUser) {
		return jwtGenerator.generate(jwtUser);
	}

}
