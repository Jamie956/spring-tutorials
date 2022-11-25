package org.example.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class X {
    @Bean
    public X x1() {
        return new X();
    }

    @Bean
    public X x2() {
        return new X();
    }
}
