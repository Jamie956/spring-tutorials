package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeName;

public class Zoo {
	public Animal animal;

	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
	@JsonSubTypes({ @JsonSubTypes.Type(value = Dog.class, name = "dog"),
			@JsonSubTypes.Type(value = Cat.class, name = "cat") })
	public static class Animal {
		public String name;
	}

	@JsonTypeName("dog")
	public static class Dog extends Animal {
		public String name;
		public double barkVolume;
		public Dog(String name) {
			super();
			this.name = name;
		}
		public Dog(String name, double barkVolume) {
			super();
			this.name = name;
			this.barkVolume = barkVolume;
		}
	}

	@JsonTypeName("cat")
	public static class Cat extends Animal {
		boolean likesCream;
		public int lives;
	}

	public Zoo(Animal animal) {
		super();
		this.animal = animal;
	}
	
}