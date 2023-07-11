package org.example.listener1;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class AppListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("ApplicationListener.onApplicationEvent: " + event.toString());
    }
}

