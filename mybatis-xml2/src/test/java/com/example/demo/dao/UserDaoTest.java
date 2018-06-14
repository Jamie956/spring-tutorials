package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;
import com.example.demo.enums.UserSexEnum;
import com.example.demo.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	private final static Logger logger = LoggerFactory.getLogger(UserDaoTest.class); 
	
	@Autowired
	private UserMapper UserMapper;
	
	@Test
	public void save() {
		UserMapper.insert(new User("tomcat", UserSexEnum.MAN, "mimi"));
		UserMapper.insert(new User("fish", UserSexEnum.WOMAN, "coco"));
	}
	
	@Test
	public void findAll() {
		List<User> us = UserMapper.getAll();
		for(User u : us){
			logger.info(u.toString());
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
		u.setUserSex(UserSexEnum.WOMAN);
		u.setNickName("niconico");
		UserMapper.update(u);
	}
	
	@Test
	public void removeById() {
		UserMapper.delete(1L);
	}
}
