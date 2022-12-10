package org.example.inject.manually;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 手动注入
 *
 * refresh 实例化bean 入口
 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization ->
 * 实例化 bean 入口
 * AbstractAutowireCapableBeanFactory#createBean step Object beanInstance = doCreateBean ->
 * 属性注入入口
 * AbstractAutowireCapableBeanFactory#doCreateBean step populateBean(beanName, mbd, instanceWrapper) ->
 * 属性注入入口
 * AbstractAutowireCapableBeanFactory#populateBean step applyPropertyValues
 *
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#createBean
 * @see org.springframework.context.support.AbstractApplicationContext#refresh
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean
 *
 *
 *
 * RootBeanDefinition.propertyValues 的变量 converted 默认为false
 * @see org.springframework.beans.factory.support.RootBeanDefinition#getPropertyValues
 */
public class Main {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("manually-inject.xml");
	}
}
