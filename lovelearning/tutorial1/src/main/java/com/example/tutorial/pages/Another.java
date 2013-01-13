package com.example.tutorial.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.corelib.components.PageLink;

@Import(library={
		//"context:js/amq/jquery-1.4.2.min.js",
		//"context:js/amq/amq_jquery_adapter.js",
		"context:js/amq/amq_prototype_adapter.js",
		"context:js/amq/amq.js",
		"context:js/amq/chat.js",
		},stylesheet={"context:css/chat.css"})
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
