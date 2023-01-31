package org.example;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

@Component
// todo not working
@AutoConfigureAfter(B.class)
public class A {
    public A() {
    }
}
