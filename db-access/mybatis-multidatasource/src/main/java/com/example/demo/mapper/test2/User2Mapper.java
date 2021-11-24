package com.example.demo.mapper.test2;

import java.util.List;

import com.example.demo.entity.User;

public interface User2Mapper {
	void insert(User user);
	
	List<User> getAll();
	
	User getOne(Long id);

	void update(User user);

	void delete(Long id);
}