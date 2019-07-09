package com.wyd.wydbatis;

import com.wyd.wydbatis.conf.Configuration;
import com.wyd.wydbatis.dao.BlogDao;
import com.wyd.wydbatis.entity.Blog;
import com.wyd.wydbatis.session.Excutor;
import com.wyd.wydbatis.session.SqlSession;

import java.sql.*;

/**
 * @ClassName :start
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/9 11:05
 * @Version :1.0
 */
public class Start {

    public static void main(String[] args) throws SQLException {
        SqlSession sqlSession = new SqlSession(new Configuration(),new Excutor());
        BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
        Blog blog = blogDao.selectBlogById(1);


    }


}
