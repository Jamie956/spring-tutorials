package org.example.aop_annotation2;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    @Test
    public void defaultAdvisorAutoProxyCreatorTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class, A.class);
        context.refresh();
        context.getBean("a", A.class).greeting();
    }
}
