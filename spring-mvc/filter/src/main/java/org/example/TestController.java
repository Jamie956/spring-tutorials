package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    /**
     * test
     *     method: post
     *     url: localhost:8080/home/hi
     *     body: 111
     */
    @PostMapping("/hi")
    @ResponseBody
    public String sayHi(@RequestBody String body) {
        System.out.println(body);
        return "ok";
    }

}
