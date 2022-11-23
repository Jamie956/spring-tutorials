package org.example.circular;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 循环依赖：spring bean 之间互相注入
 * 循环依赖开关：
 * @see org.springframework.context.support.GenericApplicationContext#setAllowCircularReferences
 * 解决方法：三级缓存解决
 * 循环依赖的过程：
 * get a -> null -> create a -> a to 2l -> populate b -> get b -> null
 * -> create b -> b to 2l -> populate a -> get a -> a from 2l to 3l ->
 * ... -> b from 2l to 1l -> ... -> continue populate b -> get b -> a from 3l to 1l
 */
public class Main {
	public static void main(String[] args) {
		GenericApplicationContext context = new GenericApplicationContext();
		context.registerBean(A.class);
		context.registerBean(B.class);

		DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();

		AbstractBeanDefinition beanDefinitionA = (AbstractBeanDefinition) beanFactory.getBeanDefinition("org.example.circular.A");
		beanDefinitionA.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

		AbstractBeanDefinition beanDefinitionB = (AbstractBeanDefinition) beanFactory.getBeanDefinition("org.example.circular.B");
		beanDefinitionB.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		context.refresh();
	}
}
