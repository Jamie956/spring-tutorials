package org.example.inject.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
	@Autowired
	B b;
	public void setB(B b) {
		//autowired 不是通过setter 装配
		System.out.println("不会执行");
	}

	public A() {
		System.out.println("create a");
	}

	public B getB() {
		return b;
	}
}
