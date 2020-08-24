package com.jamie.aop;

import com.jamie.entity.Product;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(public * com.jamie..*.*(..))")
    public void paramPointCut() {
    }

    @Around("paramPointCut()")
    public Object balabala(ProceedingJoinPoint joinPoint) throws Throwable {
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

        //获取类注解 RequestMapping
        Annotation clazzAnnotation = joinPoint.getTarget().getClass().getAnnotation(RequestMapping.class);
        Annotation clazzAnnotation2 = signature.getDeclaringType().getAnnotation(RequestMapping.class);
        //获取方法注解 GetMapping
        Annotation methodAnnotation = signature.getMethod().getAnnotation(GetMapping.class);

        //获取请求路径
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();


        //修改参数值
        Product product = (Product) args[0];
        product.setName("Martin");

        Object result = joinPoint.proceed(args);

        return result;
    }
}

