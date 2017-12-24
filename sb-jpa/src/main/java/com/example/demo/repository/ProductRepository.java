package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByName(String name);
	Product findByPrice(Integer price);
	Product findByNameAndPrice(String name, Integer price);
}
