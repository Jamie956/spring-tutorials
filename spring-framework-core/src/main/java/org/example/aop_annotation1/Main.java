package org.example.aop_annotation1;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class, A.class);
        context.refresh();
        context.getBean("a", A.class).greeting();
    }
}
