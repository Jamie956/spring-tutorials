package com.example.demo;

import io.swagger.annotations.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.User;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@ApiOperation(value = "右边显示的内容", notes = "展开的实现说明")
//	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	@GetMapping("")
	public List<User> findAll() {
		List<User> us = new ArrayList<User>();
		us.add(new User("tomcat", "123456"));
		us.add(new User("puppy", "123456"));
		return us;
	}

	@ApiOperation(value = "Save a User", notes = "Well, The Person will born!")
	@ApiImplicitParam(name = "参数名", value = "参数描述", required = true, dataType = "User")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String save(@RequestBody User user) {
		System.out.println("user => " + user);
		return "ok";
	}

	@ApiOperation(value = "Find a User by name", notes = "As follow")
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public User findUserByName(@PathVariable("name") String name) {
		System.out.println("name => " + name);
		return new User("json", "123456");
	}

	@ApiOperation(value = "Update User", notes = "")
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	public String update(@PathVariable String name, @RequestBody User user) {
		System.out.println("name => " + name);
		System.out.println("user => " + user);
		return "ok";
	}

	@ApiOperation(value = "Delete User", notes = "")
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public String remove(@PathVariable String name) {
		System.out.println("name => " + name);
		return "ok";
	}

}