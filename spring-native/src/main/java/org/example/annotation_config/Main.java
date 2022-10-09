package org.example.annotation_config;

/**
 * 配置bean:
 * 1.有@Configuration注解：
 * proxyBeanMethods默认true，表示full配置bean		(代理对象)
 * proxyBeanMethods 为false，表示 lite 配置bean	(普通对象)
 *
 * 2.无@Configuration注解：
 * 存在 @Component 注解就是 lite 配置bean
 * 存在 @ComponentScan 注解就是 lite 配置bean
 * 存在 @Import 注解就是 lite 配置bean
 * 存在 @ImportResource 注解就是 lite 配置bean
 * 存在 @Bean 注解就是 lite 配置bean
 */
public class Main {
}
