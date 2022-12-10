package org.example.circular;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
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
public class CircularReferenceTest {
	public static void main(String[] args) {
		GenericBeanDefinition bd1 = new GenericBeanDefinition();
		bd1.setBeanClass(A.class);
		bd1.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

		GenericBeanDefinition bd2 = new GenericBeanDefinition();
		bd2.setBeanClass(B.class);
		bd2.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

		GenericApplicationContext context = new GenericApplicationContext();
		context.registerBeanDefinition("a", bd1);
		context.registerBeanDefinition("b", bd2);

		context.refresh();
	}
}
