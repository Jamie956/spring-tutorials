package com.jamie.springcloud.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.util.*;

public class JwtUtil {
    private static final String SECRET = "abc123";
    private static final String ISSURE = "ddd123";
    private static final long EXPIRATION_TIME = 8 * 60 * 60 * 1000L;

    /**
     * 签发JWT
     */
    public static String generateToken(Long id, String username) {
        Map<String, Object> claims = new HashMap<>(16);
        return "Bearer " + Jwts.builder()
                .signWith( SignatureAlgorithm.HS512, SECRET )
                .setClaims( claims )
                .setIssuer(ISSURE)
                .setIssuedAt(new Date())
                .setId(id.toString())
                .setSubject(username)
                .setExpiration( new Date( Instant.now().toEpochMilli() + EXPIRATION_TIME  ) )
                .compact();
    }

    public static void main(String[] args) {
        String token = generateToken(1L, "tim");
        System.out.println(token);
    }
}