package com.jamie;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext();
        cxt.scan("com.jamie");
        cxt.refresh();

        String[] names = cxt.getBeanDefinitionNames();

        X x = cxt.getBean(X.class);
        Product product = new Product();
        x.foo(product);

        x.bar(product);

        cxt.close();

    }
}
