package com.example.demo.entity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDateDeserializer extends StdDeserializer<Date> {
	private static final long serialVersionUID = 1L;
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

	public CustomDateDeserializer() {
		this(null);
	}

	public CustomDateDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {

		String date = jsonparser.getText();
		try {
			return formatter.parse(date);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}