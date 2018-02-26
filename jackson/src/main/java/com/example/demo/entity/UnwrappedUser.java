package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class UnwrappedUser {
    public int id;
 
    @JsonUnwrapped
    public Name name;
 
    public static class Name {
        public String firstName;
        public String lastName;
		public Name(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}
    }

	public UnwrappedUser(int id, Name name) {
		super();
		this.id = id;
		this.name = name;
	}
    
}
