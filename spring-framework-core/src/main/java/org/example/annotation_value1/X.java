package org.example.annotation_value1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class X {
	//在资源文件找不到的key，使用默认值
	@Value("${properties.file.not.found.default.value:111}")
	private String propertiesFileValueNotFoundDefaultValue;
	//没用表达式，使用字符串
	@Value("pureStringValue")
	private String pureString;
}
