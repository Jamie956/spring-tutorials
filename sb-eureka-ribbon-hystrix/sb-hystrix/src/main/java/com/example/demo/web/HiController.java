package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HiService;

@RestController
public class HiController {
	
    @Autowired
    HiService hiService;
    @RequestMapping(value = "/")
    public String sayhi(){
        return hiService.sayhi();
    }

}
