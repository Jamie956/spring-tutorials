package com.example.demo.controller;

import com.example.demo.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.MyException;

@RestController
public class MyController {

    @GetMapping("/get/{no}")
    public Result<String> get(@PathVariable int no) throws MyException {
        if(no > 5) {
            throw new MyException("发生某些异常");
        }
        return new Result<String>().ok();
    }

}