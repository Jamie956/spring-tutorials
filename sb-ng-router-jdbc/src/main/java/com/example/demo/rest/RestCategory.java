package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Category;
import com.example.demo.repository.JsonTableModel;
import com.example.demo.services.CategoryService;
import com.google.gson.Gson;

@RestController
public class RestCategory {
	
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(@RequestBody Category category){
    	System.out.println(category.getName());
    	return "congratulation!";
    }	
    
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/category")
	public ResponseEntity<?> getCategoriesTable() {
		JsonTableModel result = categoryService.initCategoriesTableByMid();
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	
}
