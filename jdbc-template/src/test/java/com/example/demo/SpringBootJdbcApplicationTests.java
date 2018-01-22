package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.ICategoryDao;
import com.example.demo.model.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {
	@Autowired
	private ICategoryDao categoryDaoImpl;
	
	@Test
	public void list() {
		String list = categoryDaoImpl.listCategoryByMid();
		System.out.println(list);
	}
	
	@Test
	public void get() {
		String result = categoryDaoImpl.getCategoryById("11111");
		System.out.println("get result => "+result);
	}
	
	@Test
	public void save() {
		Category category = new Category();
		category.setId("11111");
		category.setName("cake");
		category.setMerchantId("2222222");
		category.setAlcohol("1");
		category.setCategoryUfo("food");
		category.setDisplayName("CAKE");
		category.setHidden("0");

		String result = categoryDaoImpl.saveCategory(category);
		System.out.println("save result => "+result);
	}	
	
	@Test
	public void remove() {
		String result = categoryDaoImpl.removeCategory("11111");
		System.out.println("remove result => "+result);
	}
	
	@Test
	public void update() {
		Category category = new Category();
		category.setId("11111");
		category.setName("docker");
		category.setDisplayName("DOCKER");
		category.setFlag("0");
		String result = categoryDaoImpl.updateCategory(category);
		System.out.println("update result => "+result);
	}
	
	@Test
	public void bactchInsert() {
		List<Category> categoriesList = new ArrayList<Category>();
		Category category1 = new Category();
		category1.setId("id_1");
		category1.setName("cake");
		category1.setMerchantId("mid_1");
		category1.setAlcohol("1");
		category1.setCategoryUfo("food");
		category1.setDisplayName("CAKE");
		category1.setHidden("0");
		categoriesList.add(category1);
		
		Category category2 = new Category();
		category2.setId("id_2");
		category2.setName("docker");
		category2.setMerchantId("mid_2");
		category2.setAlcohol("1");
		category2.setCategoryUfo("food");
		category2.setDisplayName("DOCKER");
		category2.setHidden("0");
		categoriesList.add(category2);
		
		categoryDaoImpl.saveCategories(categoriesList);
	}
	
}







