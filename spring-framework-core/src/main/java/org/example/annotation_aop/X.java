package org.example.annotation_aop;

import org.springframework.stereotype.Component;

@Component
public class X {
    public void foo() {
        // debug here
        System.out.println("call foo");
    }
}
