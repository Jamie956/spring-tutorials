package org.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAspectTest {
    private AnnotationConfigApplicationContext context;

    @Before
    public void createContainer() {
        context = new AnnotationConfigApplicationContext();
        //扫描包下面的注解
        context.scan("org.example");
        context.refresh();
    }

    @Test
    public void testHi() {
        //从容器获取代理对象实例
        ProxyTarget target = context.getBean(ProxyTarget.class);
        target.hi();
    }

    @Test
    public void testHi2() {
        ProxyTarget target = context.getBean(ProxyTarget.class);
        target.hi2();
    }

    @Test
    public void testHi3() {
        ProxyTarget target = context.getBean(ProxyTarget.class);
        target.hi3();
    }
}
