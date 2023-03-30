package org.example;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hi")
    @PreAuthorize("hasAnyAuthority('admins')")
    public String hi() {
        return "hi";
    }
}