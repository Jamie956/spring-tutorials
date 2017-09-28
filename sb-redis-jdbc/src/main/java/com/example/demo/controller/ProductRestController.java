package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;



@RestController
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET)
	public Product findCategoryById(@PathVariable("id") String id) {
    	Product product = productService.findProductById(id);
		return product;
	}
	
}
