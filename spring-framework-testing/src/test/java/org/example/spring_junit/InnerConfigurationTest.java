package org.example.spring_junit;

import org.example.X;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class InnerConfigurationTest {

    @Configuration
    static class MyConfig {
        @Bean
        public X getX() {
            return new X();
        }
    }

    @Autowired
    private X x;

    @Test
    public void test1() {
        Assert.assertNotNull(x);
    }

}
