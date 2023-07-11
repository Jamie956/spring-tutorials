package org.example.annotation_value2;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

public class AppConfig {
	@Bean
	public CustomEditorConfigurer myEditor() {
		CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
		Map<Class<?>, Class<? extends PropertyEditor>> map = new HashMap<>();
		map.put(B.class, MyEditor.class);
		customEditorConfigurer.setCustomEditors(map);
		return customEditorConfigurer;
	}
}
