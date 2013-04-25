package com.alibaba.sample.petstore.dal.dao;

import java.util.List;

import com.alibaba.sample.petstore.dal.dataobject.Blog;

public interface BlogDao {
	
	Blog getBlogById(Integer blogId);

    List<Blog> getBlogList();

    void insertBlog(Blog blog);

    void updateBlog(Blog blog);
}
