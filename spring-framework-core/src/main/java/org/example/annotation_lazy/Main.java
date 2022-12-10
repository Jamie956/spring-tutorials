package org.example.annotation_lazy;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	@Test
	public void annotationLazyTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationWithLazy.class);
		TestCase.assertFalse(context.getBeanFactory().containsSingleton("x"));
		TestCase.assertFalse(context.getBeanFactory().containsSingleton("y"));

		context.getBean(X.class);
		context.getBean(Y.class);

		TestCase.assertTrue(context.getBeanFactory().containsSingleton("x"));
		TestCase.assertTrue(context.getBeanFactory().containsSingleton("y"));
	}

	/**
	 * 测试 lazy 注解bean方法
	 * 测试 lazy 解决循环依赖
	 */
	@Test
	public void t2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
		context.getBean(A.class).test1();
	}

	/**
	 * 测试 lazy 注解构造方法
	 */
	@Test
	public void t3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
		context.getBean(C.class);
	}
}
