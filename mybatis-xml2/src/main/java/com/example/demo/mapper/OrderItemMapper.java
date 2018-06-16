package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.OrderItem;

@Mapper
public interface OrderItemMapper {
	void create(OrderItem orderItem);
	void deleteOrderItem();
}
