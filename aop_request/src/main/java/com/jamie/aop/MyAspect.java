package com.jamie.aop;

import com.jamie.entity.Product;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(public * com.jamie..*.*(..))")
    public void paramPointCut() {
    }

    @Around("paramPointCut()")
    public Object balabala(ProceedingJoinPoint joinPoint) throws Throwable {

//        MethodSignature msg = (MethodSignature) joinPoint.getSignature();
//        List<String> paramNameList = Arrays.asList(msg.getParameterNames());

        String classRequestMappingValue = joinPoint.getTarget().getClass().getAnnotation(RequestMapping.class).value()[0];
        String methodPostMappingValue = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(PostMapping.class).value()[0];


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String[] pathArrary = StringUtils.split(request.getRequestURI(), "/");
        String path = "/" + pathArrary[pathArrary.length-1] + "/" + pathArrary[pathArrary.length-2];




        Object[] args = joinPoint.getArgs();

        Product product = (Product) args[0];
        product.setName("Martin");

        Object result = joinPoint.proceed(args);

        System.out.println("after");

        return result;
    }
}

