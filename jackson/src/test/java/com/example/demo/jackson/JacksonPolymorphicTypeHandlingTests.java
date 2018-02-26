package com.example.demo.jackson;

import org.junit.Test;

import com.example.demo.entity.Zoo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonPolymorphicTypeHandlingTests {
	@Test
	public void whenSerializingPolymorphic_thenCorrect() throws JsonProcessingException {
		Zoo.Dog dog = new Zoo.Dog("lacy");
		Zoo zoo = new Zoo(dog);

		String result = new ObjectMapper().writeValueAsString(zoo);
		System.out.println(result);
	}

}
