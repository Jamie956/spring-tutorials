package org.example.annotation_lazy2;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyTest {
    /**
     * 测试 lazy 注解bean方法
     * 测试 lazy 解决循环依赖
     */
    @Test(expected = BeanCurrentlyInCreationException.class)
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class, A.class, B.class);
        context.refresh();
        context.getBean(A.class).test1();
    }
}
