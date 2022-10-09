package org.example.annotation_scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//有 MyComponent 注解的类不会被扫描，即使同时加了@Component注解
@ComponentScan(value = "com.cat.annotation_scan", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = MyComponent.class))
public class AppConfig2 {
}
