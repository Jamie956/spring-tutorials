package com.example.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateTests {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void save() {
		User u = new User();
		u.setId(1L);
		u.setName("tomcat");
		u.setPassword("123456");
		mongoTemplate.save(u);
	}

	@Test
	public void insert() {
		User u = new User();
		u.setId(2L);
		u.setName("How");
		u.setPassword("123456");
		mongoTemplate.insert(u);
	}
	
	@Test
	public void findById() {
		Query query = Query.query(Criteria.where("id").is(2));
		User u = mongoTemplate.findOne(query, User.class);
		System.out.println("u => "+u);
	}
	
	@Test
	public void findByName() {
		 Query query = Query.query(Criteria.where("name").is("tomcat"));
		User u = mongoTemplate.findOne(query, User.class);
		System.out.println("u => "+u);
	}
	
	@Test
	public void update() {
		Query query = Query.query(Criteria.where("id").is(1));
		Update update = new Update()
				.set("name", "Enimen")
				.set("password", "37958");
		mongoTemplate.updateFirst(query, update, User.class);
	}
	
//	@Test
//	public void findAll() {
//		Aggregation aggregation = Aggregation.newAggregation(
//				Aggregation.match(Criteria.where("password").is("123456")), 
//				Aggregation.project("id", "name", "password"),
//				Aggregation.limit(3));
//
//		System.out.println("aggregation -> " + aggregation.toString());
//
//		AggregationResults<User> aggRes = mongoTemplate.aggregate(aggregation, "user", User.class);
//		List<User> us = aggRes.getMappedResults();
//		System.out.println("us => "+us);
//	}
	@Test
	public void remove() {
		Query query = Query.query(Criteria.where("id").is(1));
		mongoTemplate.remove(query, User.class);
	}
}
