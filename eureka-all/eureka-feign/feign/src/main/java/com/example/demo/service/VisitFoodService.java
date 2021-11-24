package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "food-service")
public interface VisitFoodService {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String guest();
}
