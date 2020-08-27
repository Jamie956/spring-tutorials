package com.jamie.controller;

import com.jamie.entity.Greeting;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
    /*
    post
    localhost:8085/greet
    {
        "id": 1,
        "greet": "hhhhalo"
    }
     */
    @PostMapping("greet")
    public void sayHi(@RequestBody Greeting greet) {
        System.out.println(greet);
    }
}
