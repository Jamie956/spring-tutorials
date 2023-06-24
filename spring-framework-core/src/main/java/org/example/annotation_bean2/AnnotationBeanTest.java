package org.example.annotation_bean2;

import org.example.share.EmptyObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBeanTest {
    @Test
    public void annotationScopeTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(X.class);
        context.refresh();

        EmptyObject o1 = context.getBean(EmptyObject.class);
        EmptyObject o2 = context.getBean(EmptyObject.class);
        Assert.assertNotEquals(o1, o2);
    }
}
