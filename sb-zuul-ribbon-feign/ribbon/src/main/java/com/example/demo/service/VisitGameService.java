package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class VisitGameService {

    @Autowired
    public RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "oopsError")
    public String guest() {
        return restTemplate.getForObject("http://game-service",String.class);
    }
    
    public String oopsError() {
        return "Oop! not enough 18~, from ribbon";
    }
    
}
