package org.example.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 只监听自定义的事件
 */
@Component
public class CustomListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("自定义监听：" + event.toString());
    }
}
