package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Aspect 切面
@Aspect
// 执行顺序
@Order(5)
// spring bean register
@Component
public class MyAspect {

    /**
     * 方法切点
     */
    @Pointcut("execution(public void ProxyTarget.hi())")
    public void hi1Pointcut() {
    }

    /**
     * 方法切点的前置处理
     */
    @Before("hi1Pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("doBefore");
    }

    /**
     * 方法切点的环绕处理
     */
    @Around("hi1Pointcut()")
    public Object filterModelInterceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around 1");
        Object proceed = joinPoint.proceed();
        System.out.println("around 2");
        return proceed;
    }

    /**
     * 注解切点
     */
    @Pointcut("@annotation(CustomTest)")
    public void hi2PointCut() {

    }

    /**
     * 注解切点的前置处理
     */
    @Before("hi2PointCut()")
    public void hi2Before(JoinPoint joinPoint) {
        System.out.println("hi2 before");
    }

    @AfterReturning(value = "execution(* org.example.ProxyTarget.hi3(..))", returning = "returnVal")
    public void AfterReturning(Object returnVal) {
        System.out.println("AfterReturning: " + returnVal);
    }
}