package com.wyd.wydbatis.session;

import com.wyd.wydbatis.conf.Configuration;

import java.lang.reflect.Proxy;

/**
 * @ClassName :SqlSession
 * @Description : 会话
 * @Author : wangyudi
 * @Date : 2019/7/9 16:05
 * @Version :1.0
 */
public class SqlSession {

    private Configuration configuration;

    private Excutor excutor;

    public SqlSession(Configuration configuration, Excutor excutor) {
        this.configuration = configuration;
        this.excutor = excutor;
    }

    public <T>T selectOne(String sqlId,Object param){

        String sql = Configuration.sqlMap.getString(sqlId);
        if (sql!=null && !"".equals(sql)){
            excutor.query(sql,param);
        }
        return null;
    }

    /**
     * 动态代理
     * @param clazz
     * @param <T>
     * @return
     */
    public <T>T getMapper(Class clazz){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(this));
    }

}
