package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

@Service
public class ProductService {

	public List<Product> findAll() {
		List<Product> ps = new ArrayList<Product>();
		ps.add(new Product("01", "product01", "1.00"));
		ps.add(new Product("02", "product02", "2.00"));
		ps.add(new Product("03", "product03", "3.00"));
		return ps;
	}

}
