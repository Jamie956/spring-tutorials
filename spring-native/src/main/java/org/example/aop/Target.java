package org.example.aop;

/**
 * 被代理类
 */
public class Target implements ITarget {
    /**
     * 被增强的方法
     */
    @Override
    public void greeting() {
        System.out.println("greeting");
    }
}