package com.example.mycomponent.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;

public class NaviItem {

	@Parameter(value = "prop:pageName",defaultPrefix = BindingConstants.LITERAL) //可以用  defaultDesc  方法 设置缺省值
	private String desc;

	@Parameter(required = true,defaultPrefix = BindingConstants.LITERAL)
	private String page;

	@Inject
	private ComponentResources componentResources;

	public boolean isSelf() {
		return componentResources.getPageName().equalsIgnoreCase(page);
	}

	public String getPageDesc() {
		return desc;
	}

	public String getPageName() {
		return page;
	}

	public String defaultDesc() {
		return getPageName();
	}
}
