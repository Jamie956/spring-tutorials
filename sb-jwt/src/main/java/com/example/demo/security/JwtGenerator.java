package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import com.example.demo.domain.JwtUser;


@Component
public class JwtGenerator {

    public String generate(JwtUser jwtUser) {

        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("password", jwtUser.getPassword());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "myAwesomeKey")
                .compact();
    }
    
}
