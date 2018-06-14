package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.User;

public interface UserMapper {
	void insert(User user);

	List<User> getAll();

	User getOne(Long id);

	void update(User user);

	void delete(Long id);
}