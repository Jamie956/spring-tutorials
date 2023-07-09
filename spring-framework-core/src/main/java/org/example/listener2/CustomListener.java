package org.example.listener2;

import org.springframework.context.ApplicationListener;

/**
 * 只监听自定义的事件
 */
public class CustomListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("ApplicationListener.onApplicationEvent: " + event.toString());
    }
}
