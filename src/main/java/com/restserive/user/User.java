package com.restserive.user;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Component
@ApiModel
public class User {
	
	private Integer id;
	
	@Size(min=2, message="Message should have 2 min characters")
	@ApiModelProperty(notes="Name should have min 2 characters")
	private String name;
	@Past
	@ApiModelProperty(notes="Date of Birth Should be fast")
	private LocalDate dob;
	
	protected User()
	{
		
	}
	
	public User(Integer id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	

}
