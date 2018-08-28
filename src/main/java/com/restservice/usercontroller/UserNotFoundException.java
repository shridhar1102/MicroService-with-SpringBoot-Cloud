package com.restservice.usercontroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7152621551040363106L;
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
