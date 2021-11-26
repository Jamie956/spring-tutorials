package com.jamie.config;

import com.jamie.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    MyFilter getMyFilter() {
        return new MyFilter();
    }

    @Bean("myFilterRegistrationBeanName")
    public FilterRegistrationBean<MyFilter> registerFilter(MyFilter myFilter) {
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(myFilter);
//        registrationBean.addUrlPatterns("/halo/*");
        registrationBean.addUrlPatterns("/halo/greet");
        registrationBean.setOrder(1);
        registrationBean.setAsyncSupported(true);
        return registrationBean;
    }

}
