package com.jamie;

import com.jamie.Greeting;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("halo")
public class Controller {

    /*
    post
    localhost:8085/halo/greet
    {
        "id": 1,
        "greet": "halo"
    }
     */
    @PostMapping("greet")
    public void sayHi(@RequestBody Greeting greet) {
        System.out.println(greet);
    }

    @PostMapping("h2")
    public void sayHi2(@RequestBody Greeting greet) {
        System.out.println(greet);
    }
}
