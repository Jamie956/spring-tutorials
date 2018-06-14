package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Category;


public interface CategoryMapper {
	List<Category> listCategory0();
	
	void addCategory(Category category);
	
	void deleteCategory(Category category);
	
	Category getCategory(int id);
	
	void updateCategory(Category category);
	
	List<Category> listCategoryByName(String name);
	
	List<Category> listCategoryByIdAndName(Map<String,Object> map);
	
	List<Category> listCategory2();
}