package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDao {
	@Autowired
	private UserRepository userRepository;
	
	public boolean login(User user) {
		User u = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(u != null) {
			return true;
		}
		return false;
	}
	
	public void register(User user) {
		userRepository.save(user);
	}
}
