package com.wyd.wydbatis.session;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName :MapperProxy
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/9 16:14
 * @Version :1.0
 */
public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String interfaceName = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String sqlId = interfaceName +"."+ methodName;
        return sqlSession.selectOne(sqlId,args[0]);
    }
}
