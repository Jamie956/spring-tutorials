package com.example.demo.web.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndpoints {

	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable String id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("authentication => " + authentication);
		return "product id : " + id;
	}

	@GetMapping("/order/{id}")
	public String getOrder(@PathVariable String id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("authentication => " + authentication);
		return "order id : " + id;
	}

}