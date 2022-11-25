package org.example.autowired;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	/**
	 * 测试多个bean 时，autowired注解 注入bean的优先度
	 */
	@Test
	public void t1() {
		//registerAnnotationConfigProcessors(..): register internal bean definition
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		String[] beanDefinitionNames1 = context.getBeanDefinitionNames();
		//register candidate beans
		context.scan("org.example.autowired");
		String[] beanDefinitionNames2 = context.getBeanDefinitionNames();
		context.refresh();
		String[] beanDefinitionNames3 = context.getBeanDefinitionNames();

		TestCase.assertNotNull(context.getBean("x"));
		TestCase.assertNotNull(context.getBean("x1"));
		TestCase.assertNotNull(context.getBean("x2"));
		TestCase.assertNotSame(context.getBean("x"), context.getBean("x1"));
		TestCase.assertNotSame(context.getBean("x1"), context.getBean("x2"));
	}
}