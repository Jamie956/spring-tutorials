package org.example.annotation_aspect;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Code Generation Library:
 * CGLIB 动态生成一个被代理类的子类，
 * 子类重写被代理类的所有不是 final 修饰的方法，
 * 并在子类中采用方法拦截的技术拦截父类所有的方法调用
 * 在底层实现上，CGLIB 使用字节码处理框架 ASM，用于转换字节码并生成新的类
 */
public class Main {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class, MyAspect.class, X.class);
        context.refresh();
        context.getBean(X.class).foo();
    }
}