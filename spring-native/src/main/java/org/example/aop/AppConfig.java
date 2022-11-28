//package org.example.aop;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//import org.springframework.aop.framework.ProxyFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//
//@ComponentScan("com.cat.aop")
//public class AppConfig {
//	@Bean
//	public ProxyFactoryBean aServiceProxy() {
//		A target = new A();
//		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//		proxyFactoryBean.setTarget(target);
//		proxyFactoryBean.addAdvice(new MethodInterceptor() {
//			@Override
//			public Object invoke(MethodInvocation invocation) throws Throwable {
//				System.out.println("before...");
//				Object result = invocation.proceed();
//				System.out.println("after...");
//				return result;
//			}
//		});
//		return proxyFactoryBean;
//	}
//}
