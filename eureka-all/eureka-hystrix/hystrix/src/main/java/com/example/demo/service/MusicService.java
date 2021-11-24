package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MusicService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errorPage")
    public String listen() {
        return restTemplate.getForObject("http://music-service",String.class);
    }

    public String errorPage() {
        return "Hystrix error page.";
    }
}
