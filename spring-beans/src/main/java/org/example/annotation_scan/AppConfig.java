package org.example.annotation_scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//有 MyComponent 注解的类都会被扫描
@ComponentScan(value = "com.cat.annotation_scan", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyComponent.class))
public class AppConfig {
}
