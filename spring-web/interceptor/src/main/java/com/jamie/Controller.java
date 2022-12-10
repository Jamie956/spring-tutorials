package com.jamie;

import com.jamie.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/halo")
public class Controller {

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
        System.out.println("return: " + greet);
    }

}

