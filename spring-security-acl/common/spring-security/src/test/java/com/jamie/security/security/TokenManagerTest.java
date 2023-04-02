package com.jamie.security.security;

import org.junit.Assert;
import org.junit.Test;

public class TokenManagerTest {
    @Test
    public void test() {
        String userName = "admin";
        TokenManager tokenManager = new TokenManager();
        String token = tokenManager.createToken(userName);
        String tokenUserName = tokenManager.getUserInfoFromToken(token);
        Assert.assertEquals(userName, tokenUserName);
    }
}
