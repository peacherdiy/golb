package com.alibaba.webx.tutorial1.blog.module.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.service.form.CustomErrors;
import com.alibaba.citrus.service.form.Form;
import com.alibaba.citrus.service.form.FormService;
import com.alibaba.citrus.service.form.Group;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormField;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.sample.petstore.biz.StoreManager;
import com.alibaba.sample.petstore.dal.dataobject.Blog;
import com.alibaba.webx.tutorial1.app1.Visitor;

/**
 * 发表日记
 * 
 * @author monkeyperson
 */
public class PostBlogAction {

	@Autowired
	private FormService formService;

	@Autowired
	private StoreManager storeManager;

	public void doPostNote(Navigator nav)
			throws Exception {
		Form form = formService.getForm();
		if (form.isValid()) {
			Group group = form.getGroup("postNote");
			Blog blog1 = new Blog();
			group.setProperties(blog1);
			storeManager.insertBlog(blog1);
			// 跳转到发表博客页面
			nav.redirectTo("blogPostBlogLink");
		}

	}
	
	public void doRegister(@FormGroup("register") Visitor visitor, Navigator nav) {
        String name = visitor.getName();
        nav.redirectTo("app1Link").withTarget("form/welcome").withParameter("name", name);
    }
}
