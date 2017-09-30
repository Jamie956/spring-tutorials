package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user) {
    	userService.saveUser(user);
    }
    
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
	public User findCategoryById(@PathVariable("id") String id) {
    	User user = userService.findUserById(id);
		return user;
	}
    
    @RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public void updateCategory(@RequestBody User user) {
    	userService.updateUser(user);
    }
    
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
	public void removeUser(@PathVariable("id") String id) {
    	userService.removeUser(id);
	}
    
    @RequestMapping(value = "/api/user/all", method = RequestMethod.GET)
	public List<User> findAllUser() {
    	List<User> users = userService.findAllUser();
		return users;
	}
    
}