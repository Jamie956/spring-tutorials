package com.jamie;

import com.alicp.jetcache.anno.Cached;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MethodCacheTest {
    @Cached(name = "prefix2-", key = "#code", expire = 120, timeUnit = TimeUnit.SECONDS)
    public String get(String code) {
        return "a" + code;
    }
}
