package org.example.lifecycle;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	/**
	 * xml 定义生命周期回调方法
	 *
	 * create Z ->
	 * 1BeanNameAware.setBeanName ->
	 * 2BeanFactoryAware.setBeanFactory ->
	 * 3ApplicationContextAware.setApplicationContext ->
	 * CustomBeanPostProcessor.postProcessBeforeInitialization ->
	 * 4InitializingBean.afterPropertiesSet ->
	 * 5自定义init ->
	 * CustomBeanPostProcessor.after ->
	 * 6DisposableBean.destroy ->
	 * 自定义destroy ->
	 *
	 */
	@Test
	public void beanLifeCycleXml() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
		System.out.println("------------------------");
		context.close();
	}

	/**
	 * create Z2
	 * 1BeanNameAware.setBeanName
	 * 2BeanFactoryAware.setBeanFactory
	 * 3ApplicationContextAware.setApplicationContext
	 * CustomBeanPostProcessor.postProcessBeforeInitialization
	 * 5自定义init
	 * 4InitializingBean.afterPropertiesSet
	 * CustomBeanPostProcessor.after
	 * ------------------------
	 * 7自定义destroy
	 * 6DisposableBean.destroy
	 */
	@Test
	public void beanLifeCycleAnnotation() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Z2.class, CustomBeanPostProcessor.class);
		context.refresh();
		System.out.println("------------------------");
		context.close();
	}

}
