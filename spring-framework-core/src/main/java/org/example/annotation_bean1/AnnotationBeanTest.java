package org.example.annotation_bean1;

import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBeanTest {
    @Test(expected = UnsatisfiedDependencyException.class)
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(X.class);
        context.register(Y.class);

        // debug AbstractBeanDefinition.isAutowireCandidate
        context.refresh();
    }
}
