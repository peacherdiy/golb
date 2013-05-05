package com.alibaba.webx.tutorial1.blog.module.screen.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.sample.petstore.biz.StoreManager;
import com.alibaba.sample.petstore.biz.UserManager;
import com.alibaba.sample.petstore.dal.dataobject.Blog;
import com.alibaba.sample.petstore.dal.dataobject.User;

/**
 * 展示blog列表 
 * @author hesheng
 */
public class Default {
	
	@Autowired
	private StoreManager storeManager;
	
	public void execute(Context context) {
		List<Blog> list = storeManager.getBlogs();
		context.put("list", list);
    }
}
