package org.example.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@Test
	public void t1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ITarget halo = (ITarget) context.getBean("haloProxy");
		halo.greeting();
	}

	/**
	 * 测试 spring 的代理 ProxyFactory
	 */
	@Test
	public void t2() {
		A target = new A();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("before...");
				Object result = invocation.proceed();
				System.out.println("after...");
				return result;
			}
		});
		A a = (A) proxyFactory.getProxy();
		a.greeting();
	}

	/**
	 * 测试 ProxyFactoryBean，配置创建代理bean
	 */
	@Test
	public void t3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		context.getBean("a", A.class).greeting();
		context.getBean("aServiceProxy", A.class).greeting();
	}

	/**
	 * 测试 BeanNameAutoProxyCreator aop 代理
	 */
	@Test
	public void t4() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
		context.getBean("a", A.class).greeting();
	}

	/**
	 * 测试 DefaultAdvisorAutoProxyCreator aop 代理
	 */
	@Test
	public void t5() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);
		context.getBean("a", A.class).greeting();
		context.getBean("b", B.class).greeting();
	}

	/**
	 * 测试 Import + DefaultAdvisorAutoProxyCreator aop 代理
	 */
	@Test
	public void t6() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig4.class);
		context.getBean("a", A.class).greeting();
		context.getBean("b", B.class).greeting();
	}
}
