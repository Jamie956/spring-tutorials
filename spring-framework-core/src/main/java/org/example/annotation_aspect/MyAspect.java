package org.example.annotation_aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @Pointcut("execution(public void org.example.annotation_aspect.X.foo(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public Object aroundHandle(ProceedingJoinPoint joinPoint) throws Throwable {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        //获取参数名
//        String[] paramList = signature.getParameterNames();
//        //获取类名
//        String clazzName = signature.getDeclaringType().getName();
//        String clazzName2 = signature.getDeclaringType().getSimpleName();
//        //获取方法名
//        String methodName = signature.getName();

//        //获取参数值
        Object[] args = joinPoint.getArgs();

        System.out.println("before");
        Object result = joinPoint.proceed(args);
        System.out.println("after");

        return result;
    }
}

