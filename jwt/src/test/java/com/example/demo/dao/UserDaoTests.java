package com.example.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void registerTest() {
		User user = new User(1L, "tomcat", "123456", "admin");
		userDao.register(user);
	}
	
	@Test
	public void loginTest() {
		User user = new User("tomcat", "123456", "admin");
		boolean result = userDao.login(user);
		System.out.println("result => "+result);
	}
}
