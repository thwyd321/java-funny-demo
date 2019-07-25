package com.wyd.design.proxy.dynamic.proxy;

import com.wyd.design.proxy.statice2.datasource.DynamicDataSourceEntry;
import com.wyd.design.proxy.statice2.entity.Order;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName :OrderSerivceDynamicProxy
 * @Description :
 * jdk代理类
 * @Author : wangyudi
 * @Date : 2019/7/17 13:57
 * @Version :1.0
 */
public class OrderSerivceDynamicProxy implements InvocationHandler {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private Object obj;

    public Object getProxy(Object obj){
        this.obj = obj;
        return  Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int status = before(args);
        if (status !=1){
            throw new Exception("未实现IRouteRule接口");
        }
        Object invoke = method.invoke(obj,args);
        after();
        return invoke;
    }

    public int before(Object[] args) throws Exception{
        try {
            System.out.println("Proxy before method.");
            Order order = (Order) args[0];
            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(order.getCreateTime())));
            System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据。");
            DynamicDataSourceEntry.set(dbRouter);

        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public void after(){
        System.out.println("Proxy after method.");
    }

}
