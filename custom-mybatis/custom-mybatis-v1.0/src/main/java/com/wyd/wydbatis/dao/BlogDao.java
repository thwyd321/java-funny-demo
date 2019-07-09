package com.wyd.wydbatis.dao;

import com.wyd.wydbatis.entity.Blog;

/**
 * 与 BlogMapper.properties 对应
 */
public interface BlogDao {

    Blog selectBlogById(int id);

}
