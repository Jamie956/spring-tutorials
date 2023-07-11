package org.example.annotation_import3;

import org.example.annotation_import2.AppConfig;
import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        Assert.assertNotNull(context.getBean(EmptyObject.class));
    }
}