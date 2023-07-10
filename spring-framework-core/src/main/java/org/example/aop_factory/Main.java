package org.example.aop_factory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

public class Main {

	@Test
	public void proxyFactoryTest() {
		A target = new A();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		//增强
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
		//增强
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

}
