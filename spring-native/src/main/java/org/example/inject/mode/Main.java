package org.example.inject.mode;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注入模型分析
 *
 * 情况1：属性b无 Autowired 注解
 * 1.不做注入模式修改，不做忽略注入修改
 * 属性b为空，说明在没有对属性进行注解或声明注入模型时，属性b是不会注入的
 * 2.注入模式修改，不做忽略注入修改
 * 注入属性b，说明声明了 byType 注入模型后，属性b可以被注入
 * 3.注入模式修改，忽略注入修改
 * 属性b为空，说明虽然声明了 byType 注入模型，但是可以忽略依赖注入某个类，所以属性b没有被注入
 *
 * 情况2：属性b有 Autowired 注解
 * 1.不做注入模式修改，不做忽略注入修改
 * 注入属性b
 * 2.注入模式修改，不做忽略注入修改
 * 注入属性b
 * 3.注入模式修改，忽略注入修改
 * 注入属性b
 * 4.注入模式不修改，忽略注入B class
 * 注入属性b
 *
 * 结论：@Autowired 跟注入模式没关系，忽略注入不对它生效
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		//容器扫描指定的class
		context.register(A.class, B.class);
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		AbstractBeanDefinition beanDefinitionA = (AbstractBeanDefinition) beanFactory.getBeanDefinition("a");
		//修改 bean A的属性的注入模式
//		beanDefinitionA.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		//所有自动注入的属性类型如果为B，则忽略注入
//		beanFactory.ignoreDependencyType(B.class);

		context.refresh();
		context.getBean(A.class).printInfo();
	}
}
