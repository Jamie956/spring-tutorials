package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Category;

@Mapper
public interface CategoryMapper {
	List<Category> findAll();
	int create(Category category);
	int remove(Category category);
	Category findById(int id);
	int update(Category category);
	List<Category> findByName(String name);
	List<Category> findByIdAndName(Map<String,Object> map);
	List<Category> findJoinProduct();
	List<Category> findByPage(@Param("start") int start, @Param("count")int count);
}