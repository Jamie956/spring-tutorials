package org.example.annotation_autowired;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Test
    public void test() {
        // Debug public static Set<BeanDefinitionHolder> registerAnnotationConfigProcessors(
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EmptyObject.class, Y.class, Z.class);
        context.refresh();

        Assert.assertNotNull(context.getBean(EmptyObject.class));
        Assert.assertNotNull(context.getBean(Y.class));
        Assert.assertNotNull(context.getBean(Z.class));
    }
}