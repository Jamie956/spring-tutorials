package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Yo {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "ohShit")
    public String startUp() {
        return restTemplate.getForObject("http://music-service",String.class);
    }

    public String ohShit() {
        return "Ooh SHIT!! hystrix had to tell you, YOU ARE DONE!";
    }
}
