package com.example.demo.jackson;

import org.junit.Test;

import com.example.demo.entity.BeanWithIgnore;
import com.example.demo.entity.BeanWithIgnore2;
import com.example.demo.entity.MyBean3;
import com.example.demo.entity.PrivateBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonPropertyInclusionTests {
	@Test
	public void whenSerializingUsingJsonIgnoreProperties_thenCorrect() throws JsonProcessingException {
		BeanWithIgnore bean = new BeanWithIgnore(1, "My bean");

		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonIgnore_thenCorrect() throws JsonProcessingException {
		BeanWithIgnore2 bean = new BeanWithIgnore2(1, "My bean");

		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonInclude_thenCorrect() throws JsonProcessingException {
		MyBean3 bean = new MyBean3(1, null);

		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonAutoDetect_thenCorrect() throws JsonProcessingException {
		PrivateBean bean = new PrivateBean(1, "My bean");

		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

}
