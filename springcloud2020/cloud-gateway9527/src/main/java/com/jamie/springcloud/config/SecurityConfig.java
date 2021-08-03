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
                //关闭csrf 防护
                .csrf().disable()
                //认证配置
                .authorizeExchange()
                //指定URL无需验证
//                .pathMatchers("/payment/**").permitAll()
                .pathMatchers("/**").permitAll()
                //其他请求需要验证
//                .anyRequest().authenticated()
                .and().build();
    }
}