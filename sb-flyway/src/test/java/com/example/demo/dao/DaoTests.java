package com.example.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTests {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void save() {
		userDao.save("tomcat", 7);
		userDao.save("sliver", 1);
		userDao.save("leijun", 9);
	}
	
	@Test
	public void count() {
		int count = userDao.getCount();
		System.out.println(count);
	}
	
	@Test
	public void delete() {
		userDao.deleteByName("tomcat");
	}
	
	@Test
	public void deleteAll() {
		userDao.deleteAll();
	}
}
