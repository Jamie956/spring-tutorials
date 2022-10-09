package org.example.importing;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class TestImportSelector implements ImportSelector {
	/**
	 * 选择需要导入的类路径
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//断点
		return new String[]{"com.cat.importing.Z"};
	}
}