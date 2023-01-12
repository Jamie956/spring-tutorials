package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeyController {
    /**
     * http://localhost:8086/home/
     */
    @RequestMapping("/")
    public String index() {
        System.out.println(1/0);
        return "index";
    }

}
