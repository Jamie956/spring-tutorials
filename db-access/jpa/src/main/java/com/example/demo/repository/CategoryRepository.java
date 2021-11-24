package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category customizeFindByName(String name);
	Category customizeFindByNameAndType(String name, String type);
}
