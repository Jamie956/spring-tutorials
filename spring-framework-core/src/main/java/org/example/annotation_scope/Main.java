package org.example.annotation_scope;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();
        Assert.assertNotEquals(context.getBean(EmptyObject.class), context.getBean(EmptyObject.class));
    }
}
