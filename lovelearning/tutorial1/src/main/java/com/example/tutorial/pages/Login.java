package com.example.tutorial.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import com.example.tutorial.services.IState;

public class Login {
	@Property
	private String userName;
	
	@Property
	private String password;
	
	@SessionState
	private String user;
	
	@SessionState 
	private IState iState;

	Class<?> onSuccess() {
		if ("abc".equals(userName) && "123".equals(password)) {
			user = userName;
			return Welcome.class;
		}
		return null;
	}
}