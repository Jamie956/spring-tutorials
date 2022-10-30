package com.example.annotation1;

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
