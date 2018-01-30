package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;
import com.example.demo.enums.UserSexEnum;
import com.example.demo.mapper.test2.User2Mapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest2 {
	@Autowired
	private User2Mapper userMapper;
	
	@Test
	public void save() {
		userMapper.insert(new User("tomcat", UserSexEnum.MAN, "mimi"));
		userMapper.insert(new User("fish", UserSexEnum.WOMAN, "coco"));
	}
	
	@Test
	public void findAll() {
		List<User> us = userMapper.getAll();
		for(User u : us){
			System.out.println("u => "+u);
		}
	}
	
	@Test
	public void findById() {
		User u = userMapper.getOne(2L);
		System.out.println("u => "+u);
	}
	
	@Test
	public void update() {
		User u = userMapper.getOne(2L);
		u.setUserName("deer");
		u.setUserSex(UserSexEnum.WOMAN);
		u.setNickName("niconico");
		userMapper.update(u);
	}
	
	@Test
	public void removeById() {
		userMapper.delete(1L);
	}
	
}
