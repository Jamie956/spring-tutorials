package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Order;

public interface OrderMapper {
	List<Order> listOrder();
	Order getOrder(int id);
	void deleteOrder(int id);
}
