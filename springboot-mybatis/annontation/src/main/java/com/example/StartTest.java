package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartTest {
	@Autowired
	private UserMapper UserMapper;
	
	@Test
	public void save() {
		UserMapper.insert(new User("AA", UserSex.MAN, "aa"));
		UserMapper.insert(new User("BB", UserSex.WOMAN, "bb"));
	}
	
	@Test
	public void findAll() {
		List<User> us = UserMapper.getAll();
		for(User u : us){
			System.out.println("u => "+u);
		}
	}
	
	@Test
	public void findById() {
		User u = UserMapper.getOne(2L);
		System.out.println("u => "+u);
	}
	
	@Test
	public void update() {
		User u = UserMapper.getOne(2L);
		u.setUserName("deer");
		u.setUserSex(UserSex.WOMAN);
		u.setNickName("niconico");
		UserMapper.update(u);
	}
	
	@Test
	public void removeById() {
		UserMapper.delete(1L);
	}
}
