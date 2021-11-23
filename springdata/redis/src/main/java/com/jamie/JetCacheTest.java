package com.jamie;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JetCacheTest {

    @Autowired
    private MethodCacheTest methodCacheTest;

    /**
     * 必须 Serializable
     */
    @Data
    static class User implements Serializable {
        private String userName;
    }

    /**
     * 远程缓存
     */
    @CreateCache(name = "prefix-", expire = 120, cacheType = CacheType.REMOTE)
    private Cache<String, String> userNameCache;

    /**
     * User对象的二级缓存(本地+远程)
     */
    @CreateCache(name = "prefix-", localExpire = 60, localLimit = 100, expire = 120, cacheType = CacheType.BOTH)
    private Cache<String, User> userCache;

    @Test
    public void getUserInfo() {
        userNameCache.put("123", "userName");
        System.out.println("userNameCache : " + userNameCache.get("123"));

        User user = new User();
        user.setUserName("tim");
        userCache.put("1234", user);
        System.out.println("userCache: " + userCache.get("1234").getUserName());
    }

    @Test
    public void methodCache() {
        String s = methodCacheTest.get("1");
        System.out.println("s="+s);
    }

}

