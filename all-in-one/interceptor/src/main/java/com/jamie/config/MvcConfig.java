package com.jamie.config;

import com.jamie.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

//    @Resource
//    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //对来自/** 全路径请求进行拦截
        // addPathPatterns 用于添加拦截的规则，excludePathPatterns 用于排除拦截的规则
//        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor());
    }
}
