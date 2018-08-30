package com.restservice.versioning;

public class Name {
	
	private String firstName;
	private String secondName;
	
	public Name()
	{
		
	}
	public Name(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	
	

}
