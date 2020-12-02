package com.jamie.controller;

import com.jamie.entity.User;
import com.jamie.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserMapper userMapper;


    //http://localhost:8088/user
    @GetMapping(value = "")
    public void list() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}
