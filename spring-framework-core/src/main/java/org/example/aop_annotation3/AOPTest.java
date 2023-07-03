package org.example.aop_annotation3;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    @Test
    public void importDefaultAdvisorAutoProxyCreatorTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class, A.class, B.class);
        context.refresh();
        context.getBean("a", A.class).greeting();
        context.getBean("b", B.class).greeting();
    }
}
