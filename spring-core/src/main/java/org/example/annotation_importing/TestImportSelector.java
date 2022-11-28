package org.example.annotation_importing;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class TestImportSelector implements ImportSelector {
	/**
	 * 选择需要导入的类路径
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// debug
		return new String[]{"org.example.importing.Z"};
	}
}