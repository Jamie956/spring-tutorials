package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.mapper.OrderMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

	@Autowired
	private OrderMapper orderMapper;

	
	@Test
	public void listManyToMany() {
		List<Order> os = orderMapper.listOrder();
		for (Order o : os) {
			System.out.println(o.getCode());
			List<OrderItem> ois = o.getOrderItems();
			for (OrderItem oi : ois) {
				System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(), oi.getProduct().getPrice(),
						oi.getNumber());
			}
		}
	}

	@Test
	public void deleteMulti() {
		orderMapper.deleteOrder(2);
	}
	
}
