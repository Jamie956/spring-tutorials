package com.example.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;

@RestController
@RequestMapping("/token")
public class JwtRest {

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping
	public String generate(@RequestBody final User user) {
		return jwtUtil.generate(user);
	}

}
