package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MyConfig1 {

    @Bean
    public A createA() {
        System.out.println("create A");
        return new A();
    }

    @Bean
    public B createB() {
        System.out.println("create B");
        return new B();
    }

}
