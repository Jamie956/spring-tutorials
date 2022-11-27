package org.example.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.GenericApplicationContext;

public class DebugUtils {
    public static void printBeanDefinition(GenericApplicationContext context, String step) {
        System.out.println("----------------- " + step + " print bean definition -----------------");
        String[] beanDefinitionNames2 = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames2) {
            BeanDefinition beanDefinition = context.getBeanDefinition(name);
            System.out.println(beanDefinition);
        }
    }
}
