package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Category;
import com.example.demo.service.CategoryService;


@RestController
public class CategoryRestController {
	@Autowired
	private CategoryService categoryService;
	
    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
	public Category findCategoryById(@PathVariable("id") String id) {
    	Category result = categoryService.findCategoryById(id);
		return result;
	}
	
}
