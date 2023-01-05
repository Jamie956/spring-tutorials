package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeyController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        //mapping to html
        return "target";
    }
}
