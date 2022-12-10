package com.jamie;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public FilterRegistrationBean<MyOncePerRequestFilter> registerFilter() {
        FilterRegistrationBean<MyOncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyOncePerRequestFilter());
//        registrationBean.addUrlPatterns("/halo/*");
        registrationBean.addUrlPatterns("/halo/greet");
        registrationBean.setOrder(1);
        registrationBean.setAsyncSupported(true);
        return registrationBean;
    }

}
