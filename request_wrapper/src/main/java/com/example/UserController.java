package com.example;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {


    //localhost:8080/user/param?token=213&name=231
    @GetMapping("/param")
    public Object param(String uid, String name) {
        System.out.println(uid);
        System.out.println(name);
        return uid;
    }


    @GetMapping("/bean")
    private Object gets(User user) {
        System.out.println(user);
        return user;
    }

}
