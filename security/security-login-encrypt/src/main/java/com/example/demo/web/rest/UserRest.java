package com.example.demo.web.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/rest/user")
public class UserRest {

	@GetMapping("/info")
	public Principal userInfo(@AuthenticationPrincipal Principal principal) {
		System.out.println("principal => "+principal);
		return principal;
	}

}