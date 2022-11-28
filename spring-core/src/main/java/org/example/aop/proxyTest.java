package org.example.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.example.utils.DebugUtils;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class proxyTest {
	@Test
	public void xmlProxyFactoryBeanTest() {
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
		context.register(BeansWithBeanNameAutoProxyCreator.class);
		context.scan("org.example.aop");
		context.refresh();

		context.getBean("a", A.class).greeting();
	}

	@Test
	public void defaultAdvisorAutoProxyCreatorTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DefaultAdvisorAutoProxyCreator.class);
		context.getBean("a", A.class).greeting();
		context.getBean("b", B.class).greeting();
	}

	@Test
	public void importDefaultAdvisorAutoProxyCreatorTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansWithImportDefaultAdvisorAutoProxyCreator.class);
		context.getBean("a", A.class).greeting();
		context.getBean("b", B.class).greeting();
	}
}
