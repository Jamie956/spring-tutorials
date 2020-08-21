package com.jamie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnjoyMusic {

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String listen() {
        return "Listen to NEW AGE from port : " + port;
    }
}
