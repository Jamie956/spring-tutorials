package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class JwtUtil {
	private static final String KEY = "myAwesomeKey";
	
    public String generate(User jwtUser) {
        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
        claims.put("password", jwtUser.getPassword());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
    }
    
    public User validate(String token) {
    	User jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new User();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return jwtUser;
    }
}
