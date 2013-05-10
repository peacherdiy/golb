package com.alibaba.webx.tutorial1.blog.module.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.service.form.CustomErrors;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormField;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.sample.petstore.biz.StoreManager;
import com.alibaba.sample.petstore.dal.dataobject.Blog;

/**
 * 发表日记
 * @author monkeyperson
 */
public class PostBlogAction {
	
    @Autowired
	private StoreManager storeManager;

    public void postNote(@FormGroup("postNote") Blog blog,
                           @FormField(name = "registerError", group = "postNote") CustomErrors err,
                           HttpSession session, Navigator nav) throws Exception {
    	storeManager.insertBlog(blog);
        // 跳转到发表博客页面
        nav.redirectTo("blogPostBlogLink");
    }
}
