package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void insert() {
		User u = new User(1L, "puppy", "123456");
		mongoTemplate.insert(u);
	}

	@Test
	public void findOne() {
		Query query = Query.query(Criteria.where("id").is(1));
		User u = mongoTemplate.findOne(query, User.class);
		System.out.println("u => " + u);
	}

	@Test
	public void findById() {
		User u = mongoTemplate.findById(1, User.class);
		System.out.println("u => " + u);
	}
	
	@Test
	public void find() {
		Query query = Query.query(Criteria.where("password").is("123456"));
		List<User> us = mongoTemplate.find(query, User.class);
		System.out.println("us => " + us);
	}
	
	@Test
	public void findAll() {
		List<User> us = mongoTemplate.findAll(User.class);
		System.out.println("us => " + us);
	}
	
	@Test
	public void saveOrUpdate() {
		User u = new User(2L, "tomcat", "123456");
		mongoTemplate.save(u);
	}
	
	@Test
	public void gundan() {
		for (Long i = 3L; i < 10; i++) {
			User u = new User(i, "puppy", "123456");
			mongoTemplate.insert(u);
		}
	}
	
	@Test
	public void customAggregation() {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("name").is("puppy")),
				Aggregation.project("id", "name"), 
				Aggregation.limit(3)
				);
		AggregationResults<User> aggRes = mongoTemplate.aggregate(aggregation, "user", User.class);
		List<User> us = aggRes.getMappedResults();
		System.out.println("us => " + us);
	}
	
	@Test
	public void update() {
		Query query = Query.query(Criteria.where("id").is(1));
		Update update = new Update().set("name", "dinosaur").set("password", "123456");
		mongoTemplate.updateFirst(query, update, User.class);
	}

	@Test
	public void remove() {
		Query query = Query.query(Criteria.where("id").is(1));
		mongoTemplate.remove(query, User.class);
	}

}
