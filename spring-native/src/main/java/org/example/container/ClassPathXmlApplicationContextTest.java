package org.example.container;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {
    /**
     * bean put into map
     * @see DefaultListableBeanFactory#registerBeanDefinition
     */
    @Test
    public void refreshTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc-bean.xml");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        context.close();
    }
}
