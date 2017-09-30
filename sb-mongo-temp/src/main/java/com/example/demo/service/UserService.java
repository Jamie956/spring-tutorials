package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public class UserService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public User findUserById(String id) {
		Query query = Query.query(Criteria.where("_id").is(id));
		// Query query = Query.query(Criteria.where("name").is(name));//find user by name
		User user = mongoTemplate.findOne(query, User.class);
		return user;
	}

	public void saveUser(User user) {
		mongoTemplate.save(user);// equal to (mongoTemplate.insert(user);)
	}

	public void updateUser(User user) {
		Query query = Query.query(Criteria.where("_id").is(user.get_id()));

		Update update = new Update()
				.set("name", user.getName())
				.set("password", user.getPassword());
		mongoTemplate.updateFirst(query, update, User.class);
	}

	public void removeUser(String id) {
		Query query = Query.query(Criteria.where("_id").is(id));
		mongoTemplate.remove(query, User.class);
	}

	public List<User> findAllUser() {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("password").is("123456")), 
				Aggregation.project("_id", "name", "password"),
				Aggregation.limit(3));

		System.out.println("aggregation -> " + aggregation.toString());

		AggregationResults<User> aggRes = mongoTemplate.aggregate(aggregation, "user", User.class);
		List<User> users = aggRes.getMappedResults();
		return users;
	}

}
