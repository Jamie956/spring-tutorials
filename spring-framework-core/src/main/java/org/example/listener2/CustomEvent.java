package org.example.listener2;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 */
public class CustomEvent extends ApplicationEvent {
    public CustomEvent(Object source) {
        super(source);
    }
}