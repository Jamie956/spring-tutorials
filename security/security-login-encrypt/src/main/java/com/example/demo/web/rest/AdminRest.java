package com.example.demo.web.rest;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/admin")
public class AdminRest {

	@GetMapping("/info")
	public Principal adminInfo(@AuthenticationPrincipal Principal principal) {
		System.out.println("principal => "+principal);
		return principal;
	}
	
}
