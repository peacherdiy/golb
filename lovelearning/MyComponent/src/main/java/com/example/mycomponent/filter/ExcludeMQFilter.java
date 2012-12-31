package com.example.mycomponent.filter;

import javax.servlet.ServletContext;

import org.apache.tapestry5.ioc.def.ModuleDef;
import org.apache.tapestry5.spring.TapestrySpringFilter;


/**
 * 扩展 tapestry5.spring filter,因为 mq发送的消息被 tapestry5拦截了
 * @author hesheng
 *
 */
public class ExcludeMQFilter extends TapestrySpringFilter {

	@Override
	protected ModuleDef[] provideExtraModuleDefs(ServletContext context) {
		// TODO Auto-generated method stub
		return super.provideExtraModuleDefs(context);
	}
	
}
