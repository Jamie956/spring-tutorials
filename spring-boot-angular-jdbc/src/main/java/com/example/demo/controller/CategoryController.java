package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Category;
import com.example.demo.repository.JsonTableModel;
import com.example.demo.services.CategoriesService;
import com.google.gson.Gson;

@RestController
public class CategoryController {
	
    @RequestMapping(method = RequestMethod.POST, value = "/add1")
    public String add1(@RequestBody Category category){
    	System.out.println(category.getName());
    	
//    	return "{name:\"tomcat\"}";
    	return "congratulation!";
    }	
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/add2")
    public void add4(@RequestBody Category category){
    	System.out.println(category.getName());
    }
	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping("/categories")
	public ResponseEntity<?> getCategoriesTable() {
		JsonTableModel result = categoriesService.initCategoriesTableByMid();
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
}
