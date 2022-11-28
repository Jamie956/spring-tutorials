package org.example.primary;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	@Test
	public void t1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println(context.getBean("a"));
		System.out.println(context.getBean("a1"));

		System.out.println("-------------------");

		//没有 Primary 注解时，同时存在 a,a1 两个bean，spring 不知道取哪个
		//加了 Primary 注解，当同时存在多个bean 时，取有Primary 注解的bean
		System.out.println(context.getBean(A.class));

	}
}
