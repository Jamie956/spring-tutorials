package com.jamie;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greet {
    @RequestMapping("/")
    public String hi() {
        return "hihi";
    }
}
