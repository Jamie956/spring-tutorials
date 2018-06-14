package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Test
	public void simpleList() {
		List<Category> cs =  categoryMapper.listCategory0();
		for(Category c:cs) {
			System.out.println(c);
		}
	}
	
}
