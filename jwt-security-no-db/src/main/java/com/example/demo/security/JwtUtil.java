package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
public class JwtUtil {
	private String secret = "myAwesomeKey";

	public User validate(String token) {
		User user = null;
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			user = new User();
			user.setUserName(body.getSubject());
			user.setRole((String) body.get("role"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

	public String generate(User user) {
		Claims claims = Jwts.claims().setSubject(user.getUserName());
		claims.put("role", user.getRole());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
