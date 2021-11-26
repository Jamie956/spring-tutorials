package com.jamie.controller;

import com.jamie.entity.Greeting;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("halo")
public class FilterController {

    /*
    post
    localhost:8085/halo/greet
    {
        "id": 1,
        "greet": "hhhhalo"
    }
     */
    @PostMapping("greet")
    public void sayHi(@RequestBody Greeting greet) {
        System.out.println(greet);
    }

    @PostMapping("hi")
    public void sayHi2(@RequestBody Greeting greet) {
        System.out.println(greet);
    }
}
