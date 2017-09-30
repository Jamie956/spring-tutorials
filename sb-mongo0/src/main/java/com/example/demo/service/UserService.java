package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public class UserService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
    public void saveUser(User user) {
        mongoTemplate.insert(user);
    }

}
