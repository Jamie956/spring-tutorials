package org.example.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cat.aop")
public class AppConfig3 {
	@Bean
	public DefaultPointcutAdvisor defaultPointcutAdvisor() {
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		//定义切点方法 greeting
		pointcut.addMethodName("greeting");

		//默认切点增强
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setPointcut(pointcut);

		advisor.setAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("before...!");
				Object result = invocation.proceed();
				System.out.println("after...!");
				return result;
			}
		});

		return advisor;
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}
}
