package com.jamie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * http://localhost:9527/payment/get/1
 *
 * 自定义路由
 * http://localhost:9527/guonei
 *
 * 通过注册中心的服务名访问
 * http://localhost:9527/payment/get/1
 *
 * curl http://localhost:9527/payment/get/1 -cookies "username=jamie"
 * curl http://localhost:9527/payment/get/1 -cookies "username=jamie956"
 * curl http://localhost:9527/payment/get/1 -H "X-Request-Id:123"
 * curl http://localhost:9527/payment/get/1 -H "X-Request-Id:-123"
 *
 * 过滤器测试
 * http://localhost:9527/payment/get/1?uname=xxx
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}
