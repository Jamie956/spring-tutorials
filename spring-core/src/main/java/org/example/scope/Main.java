package org.example.scope;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 创建原型bean的入口
 * @see org.springframework.beans.factory.support.AbstractBeanFactory#doGetBean
 * 创建原型入口，最终是反射创建
 * prototypeInstance = createBean(beanName, mbd, args);
 */
public class Main {
    @Test
    public void scopeTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.cat.scope");
        //初始化bean，不会实例化原型的bean
        context.refresh();
        //对于原型bean，是创建bean入口
		X x1 = context.getBean(X.class);
		X x2 = context.getBean(X.class);
		System.out.println(x1 == x2);
        context.close();
    }
}