package com.example.demo.dao;

import java.util.ArrayList;
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
	private UserDao userDao;

	@Test
	public void save() {
		User user = new User("puppy", "123456");
		userDao.save(user);
	}

	@Test
	public void list() {
		List<User> users = userDao.findAll();
		System.out.println(users);
	}

	@Test
	public void findAllById() {
		User user = userDao.findAllById(2);
		System.out.println(user);
	}

	@Test
	public void update() {
		User user = userDao.findAllById(1);
		user.setPassword("999");
		userDao.update(user);
	}

	@Test
	public void saveUsers() {
		List<User> users = new ArrayList<User>();
		User user1 = new User(3, "dog", "123456");
		User user2 = new User(4, "deer", "123456");
		users.add(user1);
		users.add(user2);

		userDao.insertUsers(users);
	}
	
	@Test
	public void removeById() {
		userDao.removeById(1);
	}
	
}