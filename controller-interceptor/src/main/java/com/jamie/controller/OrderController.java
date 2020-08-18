package com.jamie.controller;


import com.jamie.annotation.RequiredToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequiredToken(token="1")
    @GetMapping("get")
    public String get() {
        System.out.println("getget");
        return "ok";
    }
}

