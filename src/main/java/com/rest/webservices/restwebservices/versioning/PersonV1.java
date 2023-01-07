package com.rest.webservices.restwebservices.versioning;

public class PersonV1 {
	
	private String Name;
	
	

	public PersonV1(String name) {
		super();
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "PersonV1 [Name=" + Name + "]";
	}
	
	

}
