package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Category;

public interface ICategoryDao {
	String listCategoryByMid();
	String getCategoryById(String id);
	String saveCategory(Category category);
	String removeCategory(String id);
	String updateCategory(Category category);
	String saveCategories(List<Category> categoriesList);
}
