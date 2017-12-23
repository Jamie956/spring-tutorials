package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaApplicationTests {
	@Autowired
	private ProductRepository productRepository;

	Product product = new Product();
	
	@Test
	public void all(){
		save();
		getById();
		list();
		update();
		removeById();
	}
	
	@Test
	public void save() {
		product.setName("apple");
		product.setPrice("999");
		Product result = productRepository.save(product);
		assertEquals("apple", result.getName());
		assertEquals("999", result.getPrice());
	}

	@Test
	public void getById() {
		Product result =productRepository.findOne(product.getId());
		assertEquals(product.getId(), result.getId());
		assertEquals("apple", result.getName());
		assertEquals("999", result.getPrice());
	}
	
	@Test
	public void list() {
		List<Product> products = productRepository.findAll();
		System.out.println("products => "+products);
	}
	
	@Test
	public void update() {
		product.setName("apple");
		product.setPrice("777");
		productRepository.save(product);
	}
	
	@Test
	public void removeById() {
		productRepository.delete(product.getId());
	}
	
	@Test
	public void removeAll() {
		productRepository.deleteAll();
	}
}
