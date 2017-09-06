package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Category;



@RestController
public class CategoryController {
	
	
    @RequestMapping(method = RequestMethod.POST, value = "/add1")
    public String add1(@RequestBody Category category){
    	System.out.println(category.getName());
    	System.out.println(category.getDisplay_name());
    	return "congratulation!";
    }	
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/add2")
    public void add4(@RequestBody Category category){
    	System.out.println(category.getName());
    	System.out.println(category.getDisplay_name());
    }
    
}
