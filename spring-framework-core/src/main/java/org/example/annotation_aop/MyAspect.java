package org.example.annotation_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    /**
     * execution(public void com.example.annotation1.X.foo(..))
     * execution(public * com.example.annotation1..*.*(..))
     * execution(public * com.example.annotation1..*.*(..)) && !execution(public * com.example.annotation1..*.bar*(..))
     * execution(public * com.example.annotation1..*(..))
     */
    @Pointcut("execution(public void org.example.annotation_aop.X.foo(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public Object aroundHandle(ProceedingJoinPoint joinPoint) throws Throwable {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//
//        //获取参数名
//        String[] paramList = signature.getParameterNames();
//        //获取参数值
        Object[] args = joinPoint.getArgs();
//
//        //获取类名
//        String clazzName = signature.getDeclaringType().getName();
//        String clazzName2 = signature.getDeclaringType().getSimpleName();
//        //获取方法名
//        String methodName = signature.getName();
//
//        //修改参数值
//        Product product = (Product) args[0];
//        product.setName("Martin");

        System.out.println("before");
        Object result = joinPoint.proceed(args);
        System.out.println("after");

        return result;
    }
}

