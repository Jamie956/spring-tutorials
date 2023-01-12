package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeyController {
    /**
     * http://localhost:8080/target
     */
    @RequestMapping("/target")
    public String toTarget() {
        //mapping to html
        return "target";
    }
}
