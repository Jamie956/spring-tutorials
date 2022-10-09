package com.jamie;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(public * com.jamie..*.*(..))")
    public void pc1() {}

    //排除切点
    @Pointcut("execution(public * com.jamie..*.*(..)) && !execution(public * com.jamie..*.bar*(..))" )
    public void pc2() {}

    //..代表相隔多个
    @Pointcut("execution(public * com.jamie..*(..))" )
    public void pc3() {}

    @Around("pc2()")
    public Object aroundHandle(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //获取参数名
        String[] paramList = signature.getParameterNames();
        //获取参数值
        Object[] args = joinPoint.getArgs();

        //获取类名
        String clazzName = signature.getDeclaringType().getName();
        String clazzName2 = signature.getDeclaringType().getSimpleName();
        //获取方法名
        String methodName = signature.getName();

        //修改参数值
        Product product = (Product) args[0];
        product.setName("Martin");

        Object result = joinPoint.proceed(args);

        return result;
    }
}

