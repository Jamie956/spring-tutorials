package org.example.annotation_conditional;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConditionalTest {
    @Test
    public void t1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // -> ConditionEvaluator.shouldSkip(..): load conditional class and invoke match
        context.scan("org.example.annotation_conditional");
        context.refresh();
        TestCase.assertNotNull(context.getBean(X.class));
        TestCase.assertNotNull(context.getBean(Y.class));
    }
}
