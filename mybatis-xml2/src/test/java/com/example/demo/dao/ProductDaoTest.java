package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTest {

	@Autowired
	private ProductMapper productMapper;
	
	@Test
	public void listOneToMany() {
		List<Product> ps = productMapper.listProduct();
		for(Product p : ps){
			System.out.println(p + " 对应的分类是 \t " + p.getCategory());
		}
	}

}
