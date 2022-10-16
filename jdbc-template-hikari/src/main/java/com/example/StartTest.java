package com.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void save() {
		User user = new User("zoo", "123456");
		userDao.save(user);
	}

	@Test
	public void list() {
		List<User> users = userDao.findAll();
		System.out.println("users => "+users);
	}

	@Test
	public void findAllById() {
		User user = userDao.findAllById(5);
		System.out.println("users => "+user);
	}

}