package com.jamie.security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {
    // token 有效时长
    private static final long TOKEN_EXPIRATION = 24*60*60*1000;
    // 编码秘钥
    private static final String TOKEN_SINGLE_KEY = "123456";

    // 根据用户名生成 token
    public String createToken(String username) {
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+TOKEN_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, TOKEN_SINGLE_KEY).compressWith(CompressionCodecs.GZIP).compact();
    }

    // 根据 token 得到用户信息
    public String getUserInfoFromToken(String token) {
        return Jwts.parser().setSigningKey(TOKEN_SINGLE_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public void removeToken(String token) { }
}
