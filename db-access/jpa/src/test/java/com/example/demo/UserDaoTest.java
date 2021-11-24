package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void save() {
		
		for (int i = 1; i < 10; i++) {
			User u = userRepository.save(new User("json", "json" +i+ "@gmail.com"));
			System.out.println("u => " + u);
		}
	
	}
	
	@Test
	public void findAll() {
		Page<User> pu = userRepository.findAll(new PageRequest(1, 3, Direction.ASC, "email"));
		for(User u : pu){
			System.out.println("u => " + u);
		}
	}
	
	@Test
	public void findByName() {
		List<User> us = userRepository.findByName("json", new PageRequest(1, 2, Direction.ASC, "email"));
		for(User u : us){
			System.out.println("u => " + u);
		}
	}
	
}
