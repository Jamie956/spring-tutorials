package org.example.listen;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /**
	 * 被扫描的监听器加到 beanDefinition Map：invokeBeanFactoryPostProcessors
	 * refresh 初始化多播器入口（initApplicationEventMulticaster），实例化多播器 SimpleApplicationEventMulticaster，并注册到单例池
	 * 把监听器加到多播器的 applicationListeners 集合：registerListeners
	 * 有事件发布时，从 applicationListeners 集合获取监听器，并发布事件通知
	 *
	 * 初始化时，构造事件多播器:
	 * @see org.springframework.context.support.AbstractApplicationContext#initApplicationEventMulticaster
	 *
	 * 事件发布最终执行的方法：
	 * @see org.springframework.context.event.SimpleApplicationEventMulticaster#doInvokeListener
	 *
	 * 需要发布事件时，取监听器列表的方法:
	 * @see org.springframework.context.event.AbstractApplicationEventMulticaster#retrieveApplicationListeners
	 *
	 * 存储监听列表的集合：
	 * @see org.springframework.context.event.AbstractApplicationEventMulticaster.ListenerRetriever.applicationListeners
	 *
	 * 初始化时，监听器加到多播器监听列表的方法：
	 * @see org.springframework.context.support.AbstractApplicationContext#registerListeners
     */
    @Test
    public void publishEventTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.cat.listen");
        //初始化事件多播器入口
        context.refresh();
        //发布自定义事件
        context.publishEvent(new CustomEvent("publish event"));
    }
}