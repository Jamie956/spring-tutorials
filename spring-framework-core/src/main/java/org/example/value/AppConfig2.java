package org.example.value;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

@ComponentScan("org.example.value")
public class AppConfig2 {

	@Bean
	public CustomEditorConfigurer myEditor() {
		CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
		Map<Class<?>, Class<? extends PropertyEditor>> map = new HashMap<>();
		map.put(B.class, MyEditor.class);
		customEditorConfigurer.setCustomEditors(map);
		return customEditorConfigurer;
	}
}
