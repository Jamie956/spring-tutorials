package com.example.demo.jwt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JWTTests {
	@Autowired
	private JwtUtil jwtUtil;
	
	@Test
	public void generateJWTAndValidator() {
		User jwtUser = new User(1, "puppy", "123456", "admin");
		String token = jwtUtil.generate(jwtUser);
		System.out.println("token => "+token);
		
		User result = jwtUtil.validate(token);
		System.out.println("result => "+result);
	}
}
