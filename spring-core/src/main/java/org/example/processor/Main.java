package org.example.processor;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	@Test
	public void customBeanFactoryPostProcessorTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(CustomBeanFactoryPostProcessor.class);
		context.refresh();
	}

	/**
	 * 测试自定义注解 MyAutowired1，能够属性注入
	 */
	@Test
	public void t2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(A.class, B.class, MyBeanPostProcessor.class);
		context.refresh();

		System.out.println(context.getBean(A.class).getB());
	}
}
