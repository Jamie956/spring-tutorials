package com.example.demo.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;
import org.springframework.expression.ParseException;

import com.example.demo.entity.BeanWithFilter;
import com.example.demo.entity.Event3;
import com.example.demo.entity.MyBean4;
import com.example.demo.entity.UnwrappedUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class JacksonGeneralTests {
	@Test
	public void whenUsingJsonProperty_thenCorrect() throws IOException {
		MyBean4 bean = new MyBean4(1, "My bean");
		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);

		MyBean4 resultBean = new ObjectMapper().readerFor(MyBean4.class).readValue(result);
		System.out.println(resultBean);
	}

	@Test
	public void whenSerializingUsingJsonFormat_thenCorrect() throws JsonProcessingException, ParseException {
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("UTC"));

			Date date = df.parse("20-12-2014 02:30:00");
			Event3 event = new Event3("party", date);

			String result = new ObjectMapper().writeValueAsString(event);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void whenSerializingUsingJsonUnwrapped_thenCorrect() throws JsonProcessingException, ParseException {
		UnwrappedUser.Name name = new UnwrappedUser.Name("John", "Doe");
		UnwrappedUser user = new UnwrappedUser(1, name);

		String result = new ObjectMapper().writeValueAsString(user);

		System.out.println(result);
	}

	@Test
	public void whenSerializingUsingJsonFilter_thenCorrect() throws JsonProcessingException {
		BeanWithFilter bean = new BeanWithFilter(1, "My bean");
		FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name"));

		String result = new ObjectMapper().writer(filters).writeValueAsString(bean);
		System.out.println(result);
		// assertThat(result, containsString("My bean"));
		// assertThat(result, not(containsString("id")));
	}
}
