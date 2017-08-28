package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/listProducts")
	public List<Product> listProducts(){
		return productRepository.findAll();
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody final Product product){
		productRepository.save(product);
		return "Successed!";
	}
	
}
