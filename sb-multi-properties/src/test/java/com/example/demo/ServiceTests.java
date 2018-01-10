package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.GetValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

	@Autowired
	private GetValue getValue;

	@Test
	public void getName() {
		String result = getValue.getName();
		System.out.println("result => " + result);
	}

}
