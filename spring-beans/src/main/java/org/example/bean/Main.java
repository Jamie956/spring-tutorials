package org.example.bean;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * 定义Bean的方式：
 * xml
 * @Bean
 * @Component
 * BeanDefinition
 * FactoryBean
 * supplier
 */
public class Main {
	/**
	 * 创建一个 beanDefinition 设置 X.class
	 * beanDefinition 注册到 context 容器
	 * 容器初始化之后就能从单例池获取 bean X
	 */
	@Test
	public void beanDefinitionDefinedBeanTest() {
		//创建 beanDefinition
		AbstractBeanDefinition bd = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		//设置bean 的class类型
		bd.setBeanClass(X.class);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//注册 beanDefinition
		context.registerBeanDefinition("x123", bd);
		context.refresh();

		System.out.println(context.getBean(X.class));
	}

	/**
	 * 创建一个 beanDefiniton，class类型设为自定义的 factoryBean
	 * 将 beanDefinition 注册到 context容器
	 * 容器初始化之后可以直接根据 beanName 获取 factoryBean 重写getObject 返回的实例
	 * 如果要从容器获取 factoryBean 获取 factoryName，需要在 beanName前加&
	 */
	@Test
	public void factoryBeanDefinedDeanTest() {
		AbstractBeanDefinition bd = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		bd.setBeanClass(MyFactoryBean.class);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//注册的 beanDefinition class 为 X
		context.registerBeanDefinition("customBd", bd);
		context.refresh();

		//报错，不能直接获取 MyFactoryBean 类型的bean，实际上注册的bean是x
//		System.out.println(context.getBean("customBd", MyFactoryBean.class));

		//获取FactoryBean 的BeanDefinition，而不是X
		//要获取自定义 FactoryBean，需要在name前加&
		System.out.println(context.getBean("&customBd", MyFactoryBean.class));

		//bd MyFactoryBean 实际上的类型是X
		System.out.println(context.getBean("customBd", X.class));
	}

	/**
	 * context容器注册的Bean，由Supplier 重写get 返回实例提供
	 */
	@Test
	public void supplierDefinedBeanTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Supplier<X> s = () -> {
			X x = new X();
			x.setName("123");
			return x;
		};
		context.registerBean(X.class, s);
		context.refresh();

		System.out.println(context.getBean(X.class).getName());
	}

	/**
	 * 修改beanFactory 里的 beanDefinition
	 */
	@Test
	public void beanDefinitionTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//X注册到context容器
		context.register(X.class);

		//修改beanFactory 里的 beanDefinition X的class
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		BeanDefinition beanDefinitionX = beanFactory.getBeanDefinition("x");
		beanDefinitionX.setBeanClassName("com.cat.beandefined.Z");

		context.refresh();

		//X已经被修改成Z
		System.out.println(context.getBean(Z.class));
	}

}
