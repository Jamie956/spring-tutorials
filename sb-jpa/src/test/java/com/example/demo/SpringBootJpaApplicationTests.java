package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaApplicationTests {
	@Autowired
	private ProductRepository productRepository;
	
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
		String name = "apple";
		Integer price = 999; 
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		Product p = productRepository.save(product);
		
		System.out.println("p => "+p);
		assertEquals(name, p.getName());
		assertEquals(price.toString(), p.getPrice().toString());
	}
	
	@Test
	public void saveBatch(){
		List<Product> ps = new ArrayList<Product>();
		
		String name1 = "coffee";
		Integer price1 = 444;
		Product p1 = new Product();
		p1.setName(name1);
		p1.setPrice(price1);
		ps.add(p1);
		
		String name2 = "dog";
		Integer price2 = 555;
		Product p2 = new Product();
		p2.setName(name2);
		p2.setPrice(price2);
		ps.add(p2);
		
		productRepository.save(ps);
	}
	
	@Test
	public void isExist() {
		boolean isExist = productRepository.exists(5L);
		System.out.println("isExist => "+isExist);
	}
	
	@Test
	public void getById() {
		Long id = 1L;
		Product p = productRepository.findOne(id);
		
		System.out.println("p => "+p);
		assertEquals("1", p.getId().toString());
		assertEquals("apple", p.getName());
		assertEquals("999", p.getPrice().toString());
	}
	
	@Test
	public void list() {
		List<Product> ps = productRepository.findAll();
		System.out.println("ps => "+ps);
	}
	
	@Test
	public void listByIds() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(5L);
		ids.add(7L);
		
		List<Product> ps = productRepository.findAll(ids);
		System.out.println("ps => "+ps);
	}
	
	@Test
	public void count(){
		Long cnt = productRepository.count();
		System.out.println("cnt => "+cnt);
	}
	
	@Test
	public void update() {
		Long id = 1L;
		Product p =productRepository.findOne(id);
		p.setPrice(777);
		productRepository.save(p);
	}
	
	@Test
	public void removeById() {
		Long id = 1L;
		productRepository.delete(id);
	}
	
	@Test
	public void removeAll() {
		productRepository.deleteAll();
	}
	
	@Test
	public void findByName() {
		Product p = productRepository.findByName("apple");
		System.out.println("p => "+p);
	}
	
}
