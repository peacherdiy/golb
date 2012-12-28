package com.example.tutorial.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.corelib.components.PageLink;

public class Another {

	// @Persist
	private String value;

	@Component(parameters = { "page=start" })
	private PageLink goToStart;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	String onPassivate() {
		return value;
	}

	void onActivate(String value) {
		this.value = value;
	}
}
