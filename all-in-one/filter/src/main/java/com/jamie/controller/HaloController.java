package com.jamie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaloController {
    @GetMapping("hi")
    public void sayHi() {
        System.out.println("halo");
    }
}
