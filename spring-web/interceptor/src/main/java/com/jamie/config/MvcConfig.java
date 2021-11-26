package com.jamie.config;

import com.jamie.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 添加拦截规则
        // excludePathPatterns 排除拦截规则
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
