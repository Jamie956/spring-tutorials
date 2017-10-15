package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductRest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("")
	public List<Product> list(){
		return productRepository.findAll();
	}
	
	@PostMapping("")
	public String addProduct(@RequestBody final Product product){
		productRepository.save(product);
		return "Successed!";
	}
	
}
