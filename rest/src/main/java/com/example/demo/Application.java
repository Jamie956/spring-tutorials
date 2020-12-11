package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		testResource();
	}

	//测试 从jar读取资源
	public static void testResource() throws IOException {
		Resource resource = new ClassPathResource("/templates/aa.txt");
		InputStream in = resource.getInputStream();
		byte[] b = new byte[1024];
		int len;
		StringBuilder builder = new StringBuilder();
		while ((len = in.read(b)) != -1) {
			builder.append(new String(b, 0, len));
		}
		System.out.println("==================="+builder.toString());
	}
}
