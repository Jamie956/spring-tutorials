package com.cat.web.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * http://localhost:8856/user/param?token=213&name=231
     */
    @GetMapping("/param")
    public Object param(String uid, String name) {
        System.out.println(uid);
        System.out.println(name);
        return uid;
    }

    /**
     * http://localhost:8856/user/bean
     * @param user
     * @return
     */
    @GetMapping("/bean")
    private Object gets(User user) {
        System.out.println(user);
        return user;
    }
}
