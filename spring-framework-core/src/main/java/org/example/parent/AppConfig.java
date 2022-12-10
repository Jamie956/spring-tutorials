package org.example.parent;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("com.cat.parent")
@ImportResource("classpath:parent.xml")
public class AppConfig {
}
