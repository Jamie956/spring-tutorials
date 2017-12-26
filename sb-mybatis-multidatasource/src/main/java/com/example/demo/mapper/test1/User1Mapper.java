package com.example.demo.mapper.test1;

import java.util.List;

import com.example.demo.entity.User;

public interface User1Mapper {
	void insert(User user);
	
	List<User> getAll();
	
	User getOne(Long id);

	void update(User user);

	void delete(Long id);
}