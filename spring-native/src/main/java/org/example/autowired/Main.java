package org.example.autowired;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	/**
	 * 测试多个bean 时，autowired注解 注入bean的优先度
	 */
	@Test
	public void t1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		for (String e : context.getBeanDefinitionNames()) {
//			//创建了3个X bean
//			System.out.println(e);
//		}

		System.out.println(context.getBean("x"));
		System.out.println(context.getBean("x1"));
		System.out.println(context.getBean("x2"));
	}
}