package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbConfigApplicationTests {
	@Value("${com.jamie.name}")
    private String name;
	
	@Autowired
	private Random random;
	
	@Test
	public void test1() {
		System.out.println("name => "+name);
	}
	
	@Test
	public void test2() {
		random.hi();
	}
	
}
