package com.example.mycomponent.pages;

import org.apache.tapestry5.annotations.Import;

/**
 * 消息页面
 * @author Admin
 *
 */
@Import(library={
		"context:js/amq/dojo/dojo.js",
		"context:js/amq/dojo/amq_dojo_adapter.js",
		"context:js/amq/dojo/amq.js",
		"context:js/amq/dojo/chat.js"
		},stylesheet={
		"context:css/chat.css"
		}
)
public class Msg {
	
}
