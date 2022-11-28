package org.example.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.example.utils.DebugUtils;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@Test
	public void xmlAopTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		context.setConfigLocation("spring-aop.xml");
		context.refresh();
		DebugUtils.printBeans(context, "after refresh");

		ITarget halo = (ITarget) context.getBean("haloProxy");
		halo.greeting();
	}

	@Test
	public void proxyFactoryTest() {
		A target = new A();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("before");
				Object result = invocation.proceed();
				System.out.println("after");
				return result;
			}
		});
		A a = (A) proxyFactory.getProxy();
		a.greeting();
	}

	@Test
	public void ProxyFactoryBeanTest() {
		A target = new A();
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTarget(target);
		proxyFactoryBean.addAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("before");
				Object result = invocation.proceed();
				System.out.println("after");
				return result;
			}
		});

		A a = (A) proxyFactoryBean.getObject();
		a.greeting();
	}

	@Test
	public void beanNameAutoProxyCreatorTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AnnotatedBeanWithProxy.class);
		context.scan("org.example.aop");
		context.refresh();

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
