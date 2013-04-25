package com.alibaba.sample.petstore.dal.dao.ibatis;

import java.util.List;

import com.alibaba.sample.petstore.dal.dao.BlogDao;
import com.alibaba.sample.petstore.dal.dataobject.Blog;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * 
 * @author monkeyperson
 */
public class IbatisBlogDao extends SqlMapClientDaoSupport implements BlogDao {
    public Blog getBlogById(Integer BlogId) {
        return (Blog) getSqlMapClientTemplate().queryForObject("getBlogByBlogId", BlogId);
    }

    @SuppressWarnings("unchecked")
    public List<Blog> getBlogList() {
        return getSqlMapClientTemplate().queryForList("getBlogList", null);
    }

    public void insertBlog(Blog blog) {
        getSqlMapClientTemplate().update("insertBlog", blog);
    }

    public void updateBlog(Blog blog) {
        getSqlMapClientTemplate().update("updateBlog", blog);

    }
}
