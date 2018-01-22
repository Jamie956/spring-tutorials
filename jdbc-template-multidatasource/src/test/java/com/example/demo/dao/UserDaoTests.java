package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {
	@Autowired
	private PrimaryUserDao primaryUserDao;
	@Autowired
	private SecondaryUserDao secondaryUserDao;
	
	@Test
	public void save() {
		User user1 = new User("tomcat", "123456");
		primaryUserDao.save(user1);
		
		User user2 = new User("puppy", "123456");
		secondaryUserDao.save(user2);
	}

	@Test
	public void list() {
		List<User> users1 = primaryUserDao.findAll();
		System.out.println("users1 => "+users1);
		
		List<User> users2 = secondaryUserDao.findAll();
		System.out.println("users2 => "+users2);
	}

	@Test
	public void findAllById() {
		User user1 = primaryUserDao.findAllById(1);
		System.out.println("users1 => "+user1);
		
		User user2 = secondaryUserDao.findAllById(1);
		System.out.println("users2 => "+user2);
	}

}