package org.example.listener1;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Test
    public void publishEventTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppListener.class);
        //初始化事件多播器入口
        context.refresh();
    }
}
