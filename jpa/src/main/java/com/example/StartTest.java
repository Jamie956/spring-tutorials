package com.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StartTest {
	
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

	@Test
	public void nativeQueryById() {
		User user = userRepository.nativeQueryById(5);
		System.out.println(user);
	}

	@Test
	public void paramQueryById() {
		User user = userRepository.paramQueryById(5L);
		System.out.println(user);
	}

	@Test
	public void notNativeQueryById() {
		User user = userRepository.notNativeQueryById(5L);
		System.out.println(user);
	}

	@Test
	public void nameNativeQueryById() {
		User user = userRepository.nameNativeQueryById(5);
		System.out.println(user);
	}

}
