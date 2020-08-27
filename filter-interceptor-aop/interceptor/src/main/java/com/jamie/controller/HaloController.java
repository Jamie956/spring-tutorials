package com.jamie.controller;

import com.jamie.entity.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/halo")
public class HaloController {

    /*
    post
    localhost:8085/halo/greet
    {
        "id": 1,
        "greet": "hhhhalo"
    }
     */
    @PostMapping("/greet")
    public void sayHi(@RequestBody Greeting greet) {
        System.out.println(greet);
    }

}

