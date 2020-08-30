package com.jamie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * http://localhost:8002/payment/get/1
 * get
 *
 * http://localhost:8002/payment/create
 * post
 * {
 *     "id": 2,
 *     "serial": "shake"
 * }
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
