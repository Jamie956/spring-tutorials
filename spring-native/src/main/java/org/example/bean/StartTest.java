package org.example.bean;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * 定义Bean的方式：
 * XML
 * Bean 注解
 * Component 注解
 * BeanDefinition: 实例化 bean definition，bean definition 注册到容器
 * FactoryBean：实例化 bean definition 设置 factory bean，bean definition 注册到容器
 * supplier：context 注册 bean，直接提供 bean 实例对象
 */
public class StartTest {
	@Test
	public void beanDefinitionDefinedBeanTest() {
		//实例化 bean definition，设置 bean class
		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(X.class);

		//实例化 context，注册 bean definition，refresh 初始化容器
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.registerBeanDefinition("x123", bd);
		context.refresh();

		//单例池获取 bean
		System.out.println(context.getBean(X.class));
	}

	@Test
	public void factoryBeanDefinedDeanTest() {
		//实例化 bean definition，设置 bean class 为 FactoryBean 实现类
		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(MyFactoryBean.class);

		//实例化 context，注册 bean definition，refresh 初始化容器
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.registerBeanDefinition("customBd", bd);
		context.refresh();

		//name=&+name 才能获取 factory bean，如果不加 &，获取的是 factory bean getObject 返回的对象
		System.out.println(context.getBean("&customBd", MyFactoryBean.class));
		System.out.println(context.getBean("customBd", X.class));
	}

	@Test
	public void supplierDefinedBeanTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//注册 bean 时，supplier 提供实例
		Supplier<X> supplier = X::new;
		context.registerBean(X.class, supplier);
		context.refresh();

		System.out.println(context.getBean(X.class));
	}

	@Test
	public void beanDefinitionTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(X.class);

		//从context 容器的 factory bean 获取 bean definition，修改 bean definition 的 bean class name (全类名)
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		BeanDefinition bd = beanFactory.getBeanDefinition("x");
		bd.setBeanClassName("org.example.bean.Z");

		context.refresh();

		System.out.println(context.getBean(Z.class));
	}

}
