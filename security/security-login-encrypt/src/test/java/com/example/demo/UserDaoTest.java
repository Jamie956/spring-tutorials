package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void save(){
		userRepository.save(new UserEntity("tom", "123", "ROLE_USER"));
	}
	
	@Test
	public void findByName(){
		UserEntity result = userRepository.findByName("tom");
		System.out.println(result);
	}
}
