package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void save(String name, Integer age) {
        jdbcTemplate.update("insert into user(NAME, AGE) values(?, ?)", name, age);
    }
    
    public Integer getCount() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }
    
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from user where NAME = ?", name);
    }

    public void deleteAll() {
        jdbcTemplate.update("delete from user");
    }
    
}
