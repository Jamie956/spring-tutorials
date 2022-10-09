package org.example.lazy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * lazy 注解：
 *
 */
public class Main {

	/**
	 * 测试类使用 lazy注解
	 */
	@Test
	public void t1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBeanFactory().containsSingleton("x"));
		System.out.println(context.getBean(X.class));
		System.out.println(context.getBeanFactory().containsSingleton("x"));


		System.out.println(context.getBeanFactory().containsSingleton("y"));
		System.out.println(context.getBean(Y.class));
		System.out.println(context.getBeanFactory().containsSingleton("y"));
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
