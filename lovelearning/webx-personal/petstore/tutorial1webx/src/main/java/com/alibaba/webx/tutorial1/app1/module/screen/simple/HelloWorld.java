package com.alibaba.webx.tutorial1.app1.module.screen.simple;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * hello world
 * @author hesheng
 *
 */
public class HelloWorld {
	@Autowired
	private HttpServletResponse response;
	
	public void execute() throws Exception{
		response.setContentType("text/plain");
		response.getWriter().write("你好,我的第一个webx程序");
	}
	
}
