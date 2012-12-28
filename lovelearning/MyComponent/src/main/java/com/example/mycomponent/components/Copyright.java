package com.example.mycomponent.components;

import org.apache.tapestry5.MarkupWriter;

public class Copyright {
	void beginRender(MarkupWriter writer) {
		writer.write("Copyright 2009, Foo Corp.");
	}
}
