package org.example.container;

import org.junit.Test;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DefaultListableBeanFactoryTest {
	@Test
	public void registerSingletonTest() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//singletonObjects: custom instance put into singleton objects pool
		beanFactory.registerSingleton("z", new Z());

		System.out.println(beanFactory.getBean(Z.class));
	}

	@Test
	public void registerBeanDefinitionTest() {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(Z.class);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//custom bean definition put into bean definition map
		beanFactory.registerBeanDefinition("z", beanDefinition);

		System.out.println(beanFactory.getBean(Z.class));
	}

}
