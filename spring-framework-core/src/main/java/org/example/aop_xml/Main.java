package org.example.aop_xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-aop.xml");
        context.refresh();

        ITarget halo = (ITarget) context.getBean("haloProxy");
        halo.greeting();
    }
}