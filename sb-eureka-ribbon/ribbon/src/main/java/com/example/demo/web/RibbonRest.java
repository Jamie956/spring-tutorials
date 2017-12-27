package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RibbonService;

@RestController
public class RibbonRest {

    @Autowired
    private RibbonService ribbonService;

    @RequestMapping(value = "/")
    public String everything(){
        return ribbonService.routeBeer();
    }

}
