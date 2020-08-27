package com.jamie.interceptor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Map;

public class MyInterceptor implements HandlerInterceptor {
    /**
     * 进入Controller层之前拦截请求，默认是拦截所有请求
     * @return 是否拦截当前请求，true表示拦截当前请求，false表示不拦截当前请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        //获取请求路径
        String requestURI = request.getRequestURI();
        // 获取请求path variable参数
        Map<String, String[]> ParameterMap = request.getParameterMap();

        //获取类注解
        Annotation clazzAnnotation = ((HandlerMethod) handler).getMethod().getDeclaringClass().getAnnotation(RequestMapping.class);
        //获取方法注解
        Annotation methodAnnotation = ((HandlerMethod) handler).getMethod().getAnnotation(PostMapping.class);

        return true;
    }

    /**
     * 处理完请求后但还未渲染视图之前进行的操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /**
     * 视图渲染后但还未返回到客户端时的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }

}
