package com.wyd.design.proxy.statice2.proxy;


import com.wyd.design.proxy.statice2.datasource.DynamicDataSourceEntry;
import com.wyd.design.proxy.statice2.entity.Order;
import com.wyd.design.proxy.statice2.service.IOrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName :OrderServiceStaticProxy
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/17 11:35
 * @Version :1.0
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据。");
        DynamicDataSourceEntry.set(dbRouter);
        int count = orderService.createOrder(order);
        return count;
    }
}
