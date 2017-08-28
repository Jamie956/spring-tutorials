package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;


@RestController
public class ProductController {
	
	private List<Product> products = new ArrayList<Product>(Arrays.asList(
			new Product("01","product01","1.00"),
			new Product("02","product02","2.00"),
			new Product("03","product03","3.00")
			));
	
	@RequestMapping("/listProducts")
	public List<Product> addProduct(Product product){
		return products;
	}
	
}
