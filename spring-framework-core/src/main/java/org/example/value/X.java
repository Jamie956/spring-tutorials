package org.example.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class X {
	//在资源文件找到key，使用资源文件的value
	@Value("${properties.file.value}")
	private String propertiesFileValue;

	//在资源文件找不到的key，使用字符串value
	@Value("${properties.file.not.found.value}")
	private String propertiesFileValueNotFoundValue;

	//在资源文件找不到的key，使用默认值
	@Value("${properties.file.not.found.default.value:111}")
	private String propertiesFileValueNotFoundDefaultValue;

	//没用表达式，使用字符串
	@Value("pureStringValue")
	private String pureString;

	//可以注入 beanName=yy1 的bean
	@Value("#{yy1}")
	private Y y;

	//自定义注解
	@MyValue
	private String customAnnotationValue;
}
