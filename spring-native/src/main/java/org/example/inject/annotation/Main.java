package org.example.inject.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	/**
	 * Autowired 注解标识的变量注入
	 *
	 * refresh 实例化bean 入口
	 * AbstractApplicationContext#refresh step finishBeanFactoryInitialization ->
	 * doCreateBean 反射实例化 bean
	 * AbstractAutowireCapableBeanFactory#doCreateBean step createBeanInstance ->
	 * doCreateBean 装配@Autowired 注入属性
	 * AbstractAutowireCapableBeanFactory#doCreateBean step populateBean ->
	 * 后置处理器 AutowiredAnnotationBeanPostProcessor 将@Autowired 注解属性实例化 入口
	 * AbstractAutowireCapableBeanFactory#populateBean step ibp.postProcessProperties
	 *
	 * @see org.springframework.context.support.AbstractApplicationContext#refresh
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean
	 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(A.class, B.class);
		context.refresh();
		System.out.println(context.getBean(A.class).getB());

	}
}
