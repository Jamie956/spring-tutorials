package org.example.listener2;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Test
    public void publishEventTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(CustomListener.class);
        //初始化事件多播器入口
        context.refresh();
        //发布自定义事件
        context.publishEvent(new CustomEvent("publish event"));
    }
}