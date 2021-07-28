package com.jamie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 代码配置路由
 * http://localhost:9527/guonei
 *
 * 访问注册中心的服务
 * http://localhost:9527/payment/get/1
 * http://localhost:9527/payment/discovery
 *
 * 全局过滤器拦截
 * http://localhost:9527/payment/get/1?name=tim
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}
