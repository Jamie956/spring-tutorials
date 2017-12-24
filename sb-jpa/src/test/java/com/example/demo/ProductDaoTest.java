package com.example.demo;

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
public class ProductDaoTest {
	@Autowired
	private ProductRepository productRepository;

	@Test
	public void all() {
		save();
		getById();
		list();
		update();
		removeById();
	}

	@Test
	public void save() {
		Product p = productRepository.save(new Product("apple", 999));
		System.out.println("p => " + p);
	}

	@Test
	public void saveBatch() {
		List<Product> ps = new ArrayList<Product>();
		ps.add(new Product("coffee", 555));
		ps.add(new Product("dog", 555));

		productRepository.save(ps);
	}

	@Test
	public void isExist() {
		boolean isExist = productRepository.exists(5L);
		System.out.println("isExist => " + isExist);
	}

	@Test
	public void getById() {
		Product p = productRepository.findOne(1L);
		System.out.println("p => " + p);
	}

	@Test
	public void list() {
		List<Product> ps = productRepository.findAll();
		System.out.println("ps => " + ps);
	}

	@Test
	public void listByIds() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(5L);
		ids.add(7L);

		List<Product> ps = productRepository.findAll(ids);
		System.out.println("ps => " + ps);
	}

	@Test
	public void count() {
		Long cnt = productRepository.count();
		System.out.println("cnt => " + cnt);
	}

	@Test
	public void update() {
		Product p = productRepository.findOne(1L);
		p.setPrice(777);
		productRepository.save(p);
	}

	@Test
	public void removeById() {
		productRepository.delete(1L);
	}

	@Test
	public void removeAll() {
		productRepository.deleteAll();
	}

	@Test
	public void findByName() {
		Product p = productRepository.findByName("apple");
		System.out.println("p => " + p);
	}

	@Test
	public void findByPrice() {
		Product p = productRepository.findByPrice(999);
		System.out.println("p => " + p);
	}

	@Test
	public void findByNameAndPrice() {
		Product p = productRepository.findByNameAndPrice("coffee", 555);
		System.out.println("p => " + p);
	}

}
