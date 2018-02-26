package com.example.demo.jackson;

import java.io.IOException;

import org.junit.Test;

import com.example.demo.entity.BeanWithCreator;
import com.example.demo.entity.BeanWithInject;
import com.example.demo.entity.Event2;
import com.example.demo.entity.ExtendableBean1;
import com.example.demo.entity.MyBean2;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDeserializationTests {
	@Test
	public void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
		String json = "{\"id\":1,\"theName\":\"My bean\"}";

		BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class).readValue(json);
		System.out.println(bean);
	}

	@Test
	public void whenDeserializingUsingJsonInject_thenCorrect() throws IOException {
		String json = "{\"name\":\"My bean\"}";

		InjectableValues inject = new InjectableValues.Std().addValue(int.class, 1);
		BeanWithInject bean = new ObjectMapper().reader(inject).forType(BeanWithInject.class).readValue(json);
		System.out.println(bean);
	}

	// I don't know.
	@Test
	public void whenDeserializingUsingJsonAnySetter_thenCorrect() throws IOException {
		String json = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

		ExtendableBean1 bean = new ObjectMapper().readerFor(ExtendableBean1.class).readValue(json);

		System.out.println(bean);
	}

	@Test
	public void whenDeserializingUsingJsonSetter_thenCorrect() throws IOException {
		String json = "{\"id\":1,\"name\":\"My bean\"}";

		MyBean2 bean = new ObjectMapper().readerFor(MyBean2.class).readValue(json);
		System.out.println(bean);
	}

	@Test
	public void whenDeserializingUsingJsonDeserialize_thenCorrect() throws IOException {
		String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";

		Event2 event = new ObjectMapper().readerFor(Event2.class).readValue(json);
		System.out.println(event);
	}
}
