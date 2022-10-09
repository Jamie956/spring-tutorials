package org.example.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 切点增强
 */
public class TargetAdvice implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {
    //后置增强
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after");
    }

    //前置增强
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before");
    }

    //环绕增强
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("invoke before");
        Object obj = invocation.proceed();
        System.out.println("invoke after");
        return obj;
    }
}