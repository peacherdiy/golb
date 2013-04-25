package com.alibaba.webx.tutorial1.blog.module.screen.list;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.sample.petstore.biz.StoreManager;

/**
 * 展示blog列表 
 * @author hesheng
 */
public class Default {
	
	@Autowired
	private StoreManager storeManager;
	
	public void execute(Context context) {
		storeManager.getBlogs();
        context.put("list", new String[] {
                "blog1",
                "blog2",
                "blog3",
                "blog4",
                "blog5",
                "blog6",
                "blog7"
        });
    }
}
