package com.jamie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 单机
 * http://localhost:7001/
 *
 * 集群访问
 * http://localhost:7001/
 * http://localhost:7002/
 * 别名访问，需要hosts设置 127.0.0.1     eureka7001.com
 * eureka7001.com:7001
 * eureka7002.com:7002
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7001.class, args);
    }
}
