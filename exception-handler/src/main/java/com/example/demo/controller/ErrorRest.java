package com.example.demo.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.MyException;

@RestController
public class ErrorRest {

    @RequestMapping("/e1")
    public String e1() throws Exception {
        throw new Exception("Oops come with error1");
    }

    @RequestMapping("/e2")
    public String e2() throws MyException {
        throw new MyException("Oops come with error2");
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("welcome_msg", "Welcome!");
        return "index";
    }

}