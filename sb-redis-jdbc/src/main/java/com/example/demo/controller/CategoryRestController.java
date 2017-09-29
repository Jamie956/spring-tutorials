package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    	Category category = categoryService.findCategoryById(id);
		return category;
	}
    
    @RequestMapping(value = "/api/category", method = RequestMethod.POST)
    public int saveCategory(@RequestBody Category category) {
    	int result = categoryService.saveCategory(category);
    	return result;
    }
    
    @RequestMapping(value = "/api/category", method = RequestMethod.PUT)
    public int updateCategory(@RequestBody Category category) {
    	int result = categoryService.updateCategory(category);
    	return result;
    }
    
    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.DELETE)
    public int removeCategory(@PathVariable("id") String id) {
    	int result = categoryService.removeCategory(id);
    	return result;
    }
    
}
