package org.example.aop_annotation1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;

public class AppConfig {
	@Bean
	public MethodInterceptor myAroundAdvice() {
		//环绕增强
		return new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("before");
				Object result = invocation.proceed();
				System.out.println("after");
				return result;
			}
		};
	}

	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
		BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
		//切点，匹配a开头的bean
		creator.setBeanNames("a*");
		creator.setInterceptorNames("myAroundAdvice");
		creator.setProxyTargetClass(true);

		return creator;
	}
}
