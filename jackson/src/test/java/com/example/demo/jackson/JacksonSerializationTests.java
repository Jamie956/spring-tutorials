package com.example.demo.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.expression.ParseException;

import com.example.demo.entity.Event;
import com.example.demo.entity.ExtendableBean;
import com.example.demo.entity.MyBean;
import com.example.demo.entity.MyBean1;
import com.example.demo.entity.RawBean;
import com.example.demo.entity.TypeEnumWithValue;
import com.example.demo.entity.UserWithRoot;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonSerializationTests {

	@Test
	public void whenSerializingUsingJsonAnyGetter_thenCorrect() throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", "tomcat@gmail.com");
		map.put("pwd", "123456");
		ExtendableBean bean = new ExtendableBean("My bean", map);

		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
		MyBean bean = new MyBean(1, "My bean");
		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonPropertyOrder_thenCorrect() throws JsonProcessingException {
		MyBean1 bean = new MyBean1(1, "My bean");

		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonRawValue_thenCorrect() throws JsonProcessingException {
		RawBean bean = new RawBean("My bean", "{\"attr\":false}");

		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonValue_thenCorrect() throws JsonParseException, IOException {
		String enumAsString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE2);
		System.out.println(enumAsString);
	}

	@Test
	public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException {
		// UserWithRoot user = new User(1, "John");
		UserWithRoot user = new UserWithRoot(1, "John");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

		String result = mapper.writeValueAsString(user);
		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonSerialize_thenCorrect() throws JsonProcessingException, ParseException {
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			String toParse = "20-12-2014 02:30:00";
			Date date = df.parse(toParse);
			Event event = new Event("party", date);

			String result = new ObjectMapper().writeValueAsString(event);
			System.out.println(result);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}
