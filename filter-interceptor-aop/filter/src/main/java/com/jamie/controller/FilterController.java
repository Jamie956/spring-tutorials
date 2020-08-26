package com.jamie.controller;

import com.jamie.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FilterController {
    @GetMapping("hi")
    public void sayHi() {
        System.out.println("halo");
    }

    /*
    post
    localhost:8085/greet
    {
        "id": 1,
        "greet": "hhhhalo"
    }
     */
    @PostMapping("greet")
    public void sayHi2(@RequestBody Greeting greet) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        System.out.println(greet);
    }
}
