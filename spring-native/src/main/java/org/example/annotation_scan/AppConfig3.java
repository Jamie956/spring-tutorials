package org.example.annotation_scan;

import org.springframework.context.annotation.ComponentScan;

//配置文件 spring.components 使注解路径失效
@ComponentScan(value = "com.cat.annotation_scan")
public class AppConfig3 {
}
