package org.example.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class X {

	@Value("${na}")
	private String name;

	//在资源文件找不到的key，就把 ${na123} 直接赋值给变量
	@Value("${na123}")
	private String name2;

	//在资源文件找不到的key，就把 "" 直接赋值给变量
	@Value("${na123:}")
	private String name25;

	@Value("name不从配置文件读")
	private String name3;

	//可以注入 beanName=yy1 的bean
	@Value("#{yy1}")
	private Y y;

	//报错类型不对
//	@Value("#{yy1}")
//	private String y2;

	//自定义注解
	@MyValue
	private String name4;

	@Override
	public String toString() {
		return "X{" + "name='" + name + '\'' + ", name2='" + name2 + '\'' + ", name25='" + name25 + '\'' + ", name3='" + name3 + '\'' + ", y=" + y + ", name4='" + name4 + '\'' + '}';
	}
}
