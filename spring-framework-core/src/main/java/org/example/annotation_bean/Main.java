package org.example.annotation_bean;

import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Test(expected = UnsatisfiedDependencyException.class)
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.register(Y.class);
        // debug AbstractBeanDefinition.isAutowireCandidate
        context.refresh();
    }
}
