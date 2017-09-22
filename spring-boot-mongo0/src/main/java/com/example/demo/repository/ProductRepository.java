package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.document.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {

}
