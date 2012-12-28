package com.example.mycomponent.pages;

import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.IncludeJavaScriptLibrary;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.TextStreamResponse;

import com.example.mycomponent.entity.PhoneBook;

@IncludeJavaScriptLibrary("context:js/main.js")
public class MyPhoneBook {
	
	@Property
	private String name;
	
	@SessionState
	private PhoneBook phoneBook;

	@Environmental
	private RenderSupport renderSupport;
	
	@Inject @Path("context:js/main.js") 
	private Asset mainJs;

	void setupRender() {
//		renderSupport.addScript("check = function(source, result) {"
//				+ " new Ajax.Request('MyPhoneBook.checker/' + $F(source), {"
//				+ " method: 'get'," + " onSuccess: function(transport) {"
//				+ " $(result).update(transport.responseText);" + " }" + " });"
//				+ "}");
	}

	StreamResponse onActionFromChecker(String name) {
		String result;
		if (phoneBook.selectByName(name) != null) {
			result = "<div style='color:green;'>电话本中有此联系人。</div>";
		} else {
			result = "<div style='color:red;'>电话本中没有此联系人。</div>";
		}
		return new TextStreamResponse("text/html", result);
	}
	
	List<String> onProvideCompletionsFromName(String key) {
		return phoneBook.selectNamesByKey(key);
	}

}
