package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void save() {
		Category c = categoryRepository.save(new Category("pizza", "food"));
		System.out.println("c => " + c);
	}

	@Test
	public void customizeFindByName() {
		Category c = categoryRepository.customizeFindByName("pizza");
		System.out.println("c => " + c);
	}
	
	@Test
	public void customizeFindByNameAndType() {
		Category c = categoryRepository.customizeFindByNameAndType("pizza", "food");
		System.out.println("c => " + c);
	}
	
}
