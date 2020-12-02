package com.example.demo.web.rest;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRest {

	@RequestMapping(method = RequestMethod.GET, value = "")
	public List<Product> findAll() {
		List<Product> ps = new ArrayList<Product>();
		ps.add(new Product("1", "cpu", "99"));
		ps.add(new Product("2", "main", "99"));
		return ps;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Product findById(@PathVariable("id") String id) {
		System.out.println("id => " + id);
		return new Product(id, "un", "99");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get")
	public Product getById(@RequestParam("id") String id) {
		System.out.println("id => " + id);
		return new Product(id, "nasa", "23");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "")
	public String save(@RequestBody Product product) {
		System.out.println("product => " + product);
		return "ok";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public String update(@RequestBody Product product) {
		System.out.println("product => " + product);
		return "ok";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String remove(@PathVariable("id") String id) {
		System.out.println("id => " + id);
		return "ok";
	}
}
