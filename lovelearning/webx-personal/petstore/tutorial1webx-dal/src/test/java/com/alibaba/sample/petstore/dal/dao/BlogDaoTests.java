package com.alibaba.sample.petstore.dal.dao;

import static org.junit.Assert.*;

import java.util.List;

import com.alibaba.sample.petstore.dal.dataobject.Blog;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author monkeyperson
 */
public class BlogDaoTests extends AbstractDataAccessTests {
    @Autowired
    private BlogDao blogDao;

    @Test
    public void insertBlog() {
    	Blog blog = new Blog();
    	blog.setTitle("我是标题");
    	blog.setContent("我是博客内容");
    	blog.setId(100);
    	blog.setUserId("heshengId");
		blogDao.insertBlog(blog);
		
        assertNotNull(blog);
    }
    
    @Test
    public void getBlogList() {
		List<Blog> list = blogDao.getBlogList();
		for (Blog blog : list) {
			System.out.println(blog.getTitle());
		}
    }
    
    @Test
    public void getBlogById() {
    	Blog saveBlog = new Blog();
    	saveBlog.setTitle("我是标题");
    	saveBlog.setContent("我是博客内容");
    	saveBlog.setId(100);
    	saveBlog.setUserId("heshengId");
		blogDao.insertBlog(saveBlog);
		
        Integer blogId = 100;
		Blog blog = blogDao.getBlogById(blogId);
        System.out.println(blog.getTitle());
    }
    
    @Test
    public void getUpate() {
    	Blog blog = new Blog();
    	blog.setTitle("我是标题");
    	blog.setContent("我是博客内容update");
    	blog.setId(100);
    	blog.setUserId("heshengId");
		blogDao.updateBlog(blog);
        assertNotNull(blog);
    }
}
