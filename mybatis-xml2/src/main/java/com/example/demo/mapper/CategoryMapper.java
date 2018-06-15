package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Category;


public interface CategoryMapper {
	List<Category> list();
	
	void addCategory(Category category);
	
	void deleteCategory(Category category);
	
	Category getCategory(int id);
	
	void updateCategory(Category category);
	
	List<Category> listCategoryByName(String name);
	
	List<Category> listCategoryByIdAndName(Map<String,Object> map);
	
	List<Category> listCategory2();
	
	public List<Category> listCategory3(@Param("start") int start, @Param("count")int count);
	
	List<Category> listCategory4();
}