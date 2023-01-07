package com.rest.webservices.restwebservices.versioning;

public class PersonV2 {
	
	private Name name;
	

	public PersonV2(Name name) {
		super();
		this.name = name;
	}


	public Name getName() {
		return name;
	}


	public void setName(Name name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}
	
    public static class Name{
		private String FirstName;
		private String LastName;
		
		
		
		public Name(String firstName, String lastName) {
			super();
			FirstName = firstName;
			LastName = lastName;
		}
		public String getFirstName() {
			return FirstName;
		}
		public void setFirstName(String firstName) {
			FirstName = firstName;
		}
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String lastName) {
			LastName = lastName;
		}
		@Override
		public String toString() {
			return "Name [FirstName=" + FirstName + ", LastName=" + LastName + "]";
		}
		
		
		
		
	}
	
	

}
