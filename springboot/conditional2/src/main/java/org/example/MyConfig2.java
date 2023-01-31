package org.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig2 {
    @Bean
    // create bean A if not exist bean A
    @ConditionalOnMissingBean
    public A addBean2() {
        System.out.println("new bean a in MyConfig2");
        return new A();
    }
}
