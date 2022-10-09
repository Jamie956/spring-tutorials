package org.example.lookup;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Lookup 方法注入
 */
public class Main {
	@Test
	public void t1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//A bean 是代理类
		System.out.println(context.getBean(A.class));
		System.out.println(context.getBean(A.class).test());
	}
}
