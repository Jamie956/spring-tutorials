package org.example.annotation_conditional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConditionalTest {
    @Test(expected = NoSuchBeanDefinitionException.class)
    public void t1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(X.class);
        context.refresh();
        Assert.assertNotNull(context.getBean(X.class));
    }
}
