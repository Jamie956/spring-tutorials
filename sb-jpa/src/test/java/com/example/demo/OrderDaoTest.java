package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {
	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void save() {
		Order o = orderRepository.save(new Order("google", "wait"));
		System.out.println("o => "+o);
	}

	@Test
	public void findByTitle() {
		Order o = orderRepository.findByTitle("google");
		System.out.println("o => "+o);
	}
	
	@Test
	public void findByTitleAndStatus() {
		Order o = orderRepository.findByTitleAndStatus("google", "wait");
		System.out.println("o => "+o);
	}
	
}
