package com.jamie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 集群访问
 * localhost:7001
 * localhost:7002
 * 别名访问，需要hosts设置 127.0.0.1     eureka7001.com
 * eureka7001.com:7001
 * eureka7002.com:7002
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7002.class, args);
    }
}
