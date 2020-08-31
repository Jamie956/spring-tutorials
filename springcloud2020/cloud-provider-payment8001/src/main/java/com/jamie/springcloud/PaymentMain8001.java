package com.jamie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * http://localhost:8001/payment/get/1
 * get
 *
 * http://localhost:8001/payment/create
 * post
 * {
 *     "id": 2,
 *     "serial": "shake"
 * }
 *
 * http://localhost:8001/payment/discovery
 * get
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
