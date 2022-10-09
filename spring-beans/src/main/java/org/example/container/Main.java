package org.example.container;

import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 容器：
 * 单例池
 * BeanFactory
 * ApplicationContext
 * AnnotationConfigApplicationContext
 * ClassPathXmlApplicationContext
 * FileSystemXmlApplicationContext
 */
public class Main {
	/**
	 * beanFactory 注册单例
	 */
	@Test
	public void beanFactoryCreateBeanTest() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//beanFactory 注册单例
		beanFactory.registerSingleton("z", new Z());
		System.out.println(beanFactory.getBean("z", Z.class));
	}

	/**
	 * beanFactory 注册 beanDefinition
	 */
	@Test
	public void beanFactoryCreateBeanTest2() {
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(Z.class);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//beanFactory 注册 beanDefinition
		beanFactory.registerBeanDefinition("z", beanDefinition);
		System.out.println(beanFactory.getBean("z", Z.class));
	}

	/**
	 * AnnotationConfigApplicationContext
	 *
	 * new AnnotationConfigApplicationContext();
	 * 构造一个context容器，容器可以通过register 注册BeanDefinition，通过 refresh 初始化bean
	 * 1.执行父类的构造方法
	 * 1.1
	 * GenericApplicationContext extends AbstractApplicationContext
	 * 实例化一个 DefaultListableBeanFactory
	 * @see org.springframework.context.support.GenericApplicationContext#GenericApplicationContext()
	 * 1.2
	 * AbstractApplicationContext extends DefaultResourceLoader
	 * 实例化一个 PathMatchingResourcePatternResolver
	 * @see org.springframework.context.support.AbstractApplicationContext#AbstractApplicationContext()
	 * 1.3
	 * DefaultResourceLoader
	 * 初始化类加载器
	 * @see org.springframework.core.io.DefaultResourceLoader#DefaultResourceLoader()
	 * 2.注册内置后置处理器（加到 context 容器的 BeanDefinitionMap），返回成功注册的BeanDefinition 集合
	 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor
	 * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
	 * @see org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
	 * @see org.springframework.context.event.EventListenerMethodProcessor
	 * @see org.springframework.context.event.DefaultEventListenerFactory
	 *
	 * context.scan("com.cat.ioc");
	 * 1.
	 * doScan step findCandidateComponents
	 * 扫描包路径下的注解类
	 * 2.
	 * doScan step registerBeanDefinition
	 * 将类的 BeanDefinition 注册到 BeanDefinitionMap
	 * @see org.springframework.context.annotation.ClassPathBeanDefinitionScanner#doScan
	 *
	 * context.refresh()
	 *
	 */
	@Test
	public void annotationConfigApplicationContextTest() {
		//注册内置后置处理器入口
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		//环境变量
		System.out.println(context.getEnvironment().getSystemEnvironment());
		//获取资源文件
		context.getResource("");

		System.out.println("-------------- after new AnnotationConfigApplicationContext --------------");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		System.out.println("-------------- before scan --------------");
		//扫描包路径下的注解类, 将类的 BeanDefinition 注册到 BeanDefinitionMap
		context.scan("com.cat.container");

		//bean初始化
		context.refresh();

		System.out.println("-------------- after context.refresh() --------------");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		context.close();
	}

	/**
	 * ClassPathXmlApplicationContext
	 *
	 * beanDefinition 注册
	 * 1.如果 context 容器是 AnnotationConfigApplicationContext
	 * AbstractApplicationContext#refresh step invokeBeanFactoryPostProcessors ->
	 * DefaultListableBeanFactory#registerBeanDefinition step this.beanDefinitionMap.put
	 * @see org.springframework.context.support.AbstractApplicationContext#refresh
	 * @see DefaultListableBeanFactory#registerBeanDefinition
	 * 2.如果 context 容器是 ClassPathXmlApplicationContext
	 * AbstractApplicationContext#refresh step obtainFreshBeanFactory ->
	 * DefaultListableBeanFactory#registerBeanDefinition step this.beanDefinitionMap.put
	 * @see ClassPathXmlApplicationContext
	 */
	@Test
	public void classPathXmlApplicationContextTest(){
		//初始化容器、配置路径和bean
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc-bean.xml");
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		context.close();
	}

	@Test
	public void classPathXmlApplicationContextTest2(){
		//初始化容器、配置路径和bean
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		context.setConfigLocation("ioc-bean.xml");
		context.refresh();
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		context.close();
	}


}
