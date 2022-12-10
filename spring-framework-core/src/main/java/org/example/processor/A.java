package org.example.processor;

import org.springframework.stereotype.Component;

@Component
public class A {
	//自定义注解
	@MyAutowired1
	private B b;

	public B getB() {
		return b;
	}
}
