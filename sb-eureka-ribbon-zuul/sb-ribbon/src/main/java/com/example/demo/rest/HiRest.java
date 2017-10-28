package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HiService;

@RestController
public class HiRest {

    @Autowired
    private HiService hiService;

    @RequestMapping(value = "/")
    public String hi(){
        return hiService.hiService();
    }

}
