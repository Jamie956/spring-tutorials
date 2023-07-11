package org.example.annotation_value1;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Test
    public void readPropertiesValue() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(X.class);
        context.refresh();

        X bean = context.getBean(X.class);
        Assert.assertEquals("111", bean.getPropertiesFileValueNotFoundDefaultValue());
        Assert.assertEquals("pureStringValue", bean.getPureString());
    }
}
