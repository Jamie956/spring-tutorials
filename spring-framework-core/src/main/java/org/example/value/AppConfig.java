package org.example.value;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("org.example.value")
//加载配置文件
@PropertySource("classpath:spring.properties")
public class AppConfig {
}
