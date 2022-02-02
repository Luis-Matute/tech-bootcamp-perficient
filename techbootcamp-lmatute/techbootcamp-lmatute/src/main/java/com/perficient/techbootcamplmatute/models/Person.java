package com.perficient.techbootcamplmatute.models;

public class Person {
	
	private int id;
	private String name;
	
	public Person() {}
	
	public Person(String name) {
		this.name = name;
	}
	
	public String greeting() {
		return "Hello!";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
