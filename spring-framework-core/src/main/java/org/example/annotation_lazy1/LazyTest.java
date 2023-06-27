package org.example.annotation_lazy1;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyTest {
    @Test
    public void annotationLazyTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(X.class);
        context.refresh();

        TestCase.assertFalse(context.getBeanFactory().containsSingleton("x"));
        context.getBean(X.class);
        TestCase.assertTrue(context.getBeanFactory().containsSingleton("x"));
    }
}
