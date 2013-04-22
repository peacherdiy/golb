package com.alibaba.webx.tutorial1.blog.module.screen.list;

import com.alibaba.citrus.turbine.Context;

/**
 * 展示blog列表 
 * @author hesheng
 */
public class GetBlogList {
	public void execute(Context context) {
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
