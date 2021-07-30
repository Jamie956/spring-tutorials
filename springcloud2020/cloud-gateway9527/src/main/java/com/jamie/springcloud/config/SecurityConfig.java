package com.jamie.springcloud.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                //自定义登录页面
                .formLogin().and().exceptionHandling()
                //关闭csrf 防护
                .and().csrf().disable()
                //认证配置
                .authorizeExchange()
                //指定URL 直接访问，无需验证
                .pathMatchers("/payment/**").permitAll()
                //其他请求 需要身份验证
//                .anyRequest().authenticated()
                .and().build();
    }
}