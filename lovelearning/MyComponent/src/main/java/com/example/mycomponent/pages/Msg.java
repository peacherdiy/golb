package com.example.mycomponent.pages;

import org.apache.tapestry5.annotations.Import;

/**
 * 消息页面
 * @author Admin
 *
 */
@Import(library={
		"context:js/amq/jquery-1.4.2.min.js",
		"context:js/amq/amq_jquery_adapter.js",
		"context:js/amq/amq.js"
		//"context:js/amq/chat.js",
		})
public class Msg {
	
}
