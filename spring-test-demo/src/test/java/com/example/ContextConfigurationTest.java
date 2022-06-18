package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
@ContextConfiguration(classes = {SpringConfig.class})

@ContextConfiguration(classes = TestConfig.class)

@ContextHierarchy({
		@ContextConfiguration("/parent-config.xml"),
		@ContextConfiguration("/child-config.xml")
})

@ContextConfiguration("/test-config.xml")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class ContextConfigurationTest {
    @Autowired
    private User user;

    @Test
    public void test1() {
        System.out.println(user);
    }
}

