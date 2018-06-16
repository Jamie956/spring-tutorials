package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Order;

public interface OrderMapper {
	List<Order> findJoinOrderItemAndProduct();
	Order findById(int id);
	void removeWithOrderItem(int id);
}
