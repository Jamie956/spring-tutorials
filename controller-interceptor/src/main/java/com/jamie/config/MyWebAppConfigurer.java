package com.jamie.config;

import com.jamie.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    //关键，将拦截器作为bean写入配置中
    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //多个拦截器组成一个拦截器链
        // addPathPatterns用于添加拦截规则
        // excludePathPatterns用户排除拦截
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**"); //对来自/** 全路径请求进行拦截
        super.addInterceptors(registry);
    }
}
