package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Order;

@Mapper
public interface OrderMapper {
	List<Order> findJoinOrderItemAndProduct();
	Order findById(int id);
	void removeWithOrderItem(int id);
}
