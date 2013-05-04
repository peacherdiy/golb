package com.alibaba.sample.petstore.dal.dao;

import static org.junit.Assert.*;

import java.util.List;

import com.alibaba.sample.petstore.dal.dataobject.Blog;
import com.alibaba.sample.petstore.dal.dataobject.User;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author monkeyperson
 */
public class BlogDaoTests extends AbstractDataAccessTests {
    @Autowired
    private BlogDao blogDao;
    
    
    @Test
    public void getBlogList() {
		List<Blog> list = blogDao.getBlogList();
		for (Blog blog : list) {
			System.out.println(blog.getTitle());
		}
    }
    
    @Test
    public void insertBlog() {
    	Blog blog = new Blog();
    	blog.setTitle("我是标题");
    	blog.setContent("我是博客内容");
    	blog.setId(100);
    	blog.setUserId("heshengId");
		blogDao.insertBlog(blog);
		
        assertNotNull(blog);
        
        Blog getBlog = blogDao.getBlogById(100);
        System.out.println(getBlog);
    }
    
    @Test
    public void getBlogById() {
		Blog blog = blogDao.getBlogById(2);
		assertNotNull(blog);
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
