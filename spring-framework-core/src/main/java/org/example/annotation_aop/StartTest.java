package org.example.annotation_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Code Generation Library
 * CGLIB 通过动态生成一个需要被代理类的子类（即被代理类作为父类），
 * 该子类重写被代理类的所有不是 final 修饰的方法，
 * 并在子类中采用方法拦截的技术拦截父类所有的方法调用
 * 在底层实现上，CGLIB 使用字节码处理框架 ASM，该框架用于转换字节码并生成新的类
 */
public class StartTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext();
        cxt.scan("org.example.annotation_aop");
        cxt.refresh();

        X x = cxt.getBean(X.class);
        x.foo();
        cxt.close();
    }
}
