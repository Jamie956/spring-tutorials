package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig1 {
    @Bean
    public A addBean1() {
        System.out.println("new bean a in MyConfig1");
        return new A();
    }
}
