package org.example.inject.type;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * I1和I2 实现接口I，class A 装配属性I i
 *
 * 装配模式为 byType
 * 抛出异常
 * org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.cat.inject.type.I' available: expected single matching bean but found 2: i1,i2
 *
 * 装配模式为 byName
 * i=null
 */
public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("type-inject.xml");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		System.out.println(context.getBean(A.class));
	}
}
