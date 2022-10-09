package com.jamie;

import org.springframework.stereotype.Component;

@Component
public class X {
    public void foo(Product product) {
        System.out.println("call foo");
    }
    public void bar(Product product) {
        System.out.println("call bar");
    }

}
