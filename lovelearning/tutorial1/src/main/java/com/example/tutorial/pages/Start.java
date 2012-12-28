package com.example.tutorial.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;

public class Start {

	//@Property
	private String theValue = "Init Value";

	@InjectPage
	private Another anotherPage;

	public String getGreeting() {
		return "Hello Tapestry!";
	}

	@OnEvent(value = "action", component = "actionLink1")
	Object toAnotherPage() {
		return anotherPage;
	}

	Object onSuccessFromForm1() {
		anotherPage.setValue(theValue);
		return anotherPage;
	}

	public String getTheValue() {
		System.out.println("getTheValue : '" + theValue + "'");
		return theValue;
	}

	public void setTheValue(String theValue) {
		System.out.println("setTheValue : '" + theValue + "'");
		this.theValue = theValue;
	}
}
