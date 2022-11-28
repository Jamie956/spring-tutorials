package org.example.parent;

import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	/**
	 * 测试 父子bean
	 */
	@Test
	public void t1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		//B 继承了父bean 多例的特性
		System.out.println(context.getBean(B.class));
		System.out.println(context.getBean(B.class));
	}

	/**
	 * 测试 父子beanFactory
	 */
	@Test
	public void t2() {
		//父
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		AbstractBeanDefinition bd = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		bd.setBeanClass(A.class);
		factory.registerBeanDefinition("a", bd);

		//子
		DefaultListableBeanFactory factory1 = new DefaultListableBeanFactory();
		AbstractBeanDefinition bd1 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		bd1.setBeanClass(B.class);
		factory1.registerBeanDefinition("b", bd1);
		//父子关联，能够获取父factory 的bean
		factory1.setParentBeanFactory(factory);

		System.out.println(factory1.getBean("a"));
	}
}
