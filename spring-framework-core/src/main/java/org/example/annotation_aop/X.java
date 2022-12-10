package org.example.annotation_aop;

import org.springframework.stereotype.Component;

@Component
public class X {
    public void foo() {
        System.out.println("call foo");
    }
}
