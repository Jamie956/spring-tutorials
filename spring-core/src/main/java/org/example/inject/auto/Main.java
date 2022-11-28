package org.example.inject.auto;

import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 装配/注入模式：
 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_NO
 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_BY_NAME
 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE
 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_CONSTRUCTOR
 */
public class Main {
	/**
	 * xml 自动装配
	 *
	 * 实例化 bean 阶段
	 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization ->
	 * 装配属性入口
	 * AbstractBeanFactory#doCreateBean step populateBean ->
	 * byType 注入，如果属性还没实例化就去实例化
	 * AbstractAutowireCapableBeanFactory#populateBean step autowireByType ->
	 * 属性注入 入口
	 * AbstractAutowireCapableBeanFactory#populateBean step applyPropertyValues
	 *
	 * @see org.springframework.context.support.AbstractApplicationContext#refresh
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean
	 */
	@Test
	public void xmlAutoInjectTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("auto-inject.xml");
		A bean = context.getBean(A.class);
		System.out.println(bean.getB());
	}

	/**
	 * 无注解情况下，编程式注入
	 * 注入过程和 XML注入基本相同
	 */
	@Test
	public void autoInjectTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//class 扫描
		context.register(A.class, B.class);

		//设置注入模式
		AbstractBeanDefinition bd = (AbstractBeanDefinition) context.getBeanDefinition("a");
		bd.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

		context.refresh();

		System.out.println(context.getBean(A.class).getB());
	}
}