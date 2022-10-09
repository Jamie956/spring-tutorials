package org.example.container;

import org.junit.Test;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTest {
	@Test
	public void beanFactoryAddSingleton() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//实例加入 bean factory 的单例池 singletonObjects
		beanFactory.registerSingleton("z", new Z());
		System.out.println(beanFactory.getBean("z", Z.class));
	}

	@Test
	public void beanFactoryAddBeanDefinition() {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(Z.class);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//new bean definition 加入 bean factory 的 beanDefinitionMap
		beanFactory.registerBeanDefinition("z", beanDefinition);
		System.out.println(beanFactory.getBean("z", Z.class));
	}

	/**
	 * new AnnotationConfigApplicationContext()
	 * 1.AnnotationConfigApplicationContext -> GenericApplicationContext -> AbstractApplicationContext -> DefaultResourceLoader
	 * 父类构造函数实例化 PathMatchingResourcePatternResolver
	 * @see org.springframework.context.support.AbstractApplicationContext#AbstractApplicationContext()
	 * 父类构造函数实例化 bean factory
	 * @see org.springframework.context.support.GenericApplicationContext#GenericApplicationContext()
	 * @see org.springframework.core.io.DefaultResourceLoader#DefaultResourceLoader()
	 * 2.注册后置处理器
	 * @see org.springframework.context.annotation.AnnotationConfigUtils#registerAnnotationConfigProcessors(BeanDefinitionRegistry, Object)
	 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory#registerBeanDefinition
	 *
	 * context.scan()
	 * 1.doScan step findCandidateComponents: 扫描包路径下的注解类
	 * 2.doScan step registerBeanDefinition: BeanDefinition 注册到 BeanDefinitionMap
	 * @see org.springframework.context.annotation.ClassPathBeanDefinitionScanner#doScan
	 *
	 * context.refresh()
	 */
	@Test
	public void annotationContextStartUpInit() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		//扫描包路径下的注解类, 将扫描的类 BeanDefinition 注册到 BeanDefinitionMap
		context.scan("org.example.container");
		System.out.println("-------------- scan --------------");

		context.refresh();
		System.out.println("-------------- refresh --------------");

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		context.close();
	}

	/**
	 * bean definition register
	 * @see DefaultListableBeanFactory#registerBeanDefinition
	 */
	@Test
	public void xmlContext() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc-bean.xml");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		context.close();
	}
}
