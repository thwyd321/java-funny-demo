package com.wyd.design.proxy.statice2.service.impl;

import com.wyd.design.proxy.statice2.dao.OrderDao;
import com.wyd.design.proxy.statice2.entity.Order;
import com.wyd.design.proxy.statice2.service.IOrderService;

/**
 * @ClassName :OrderServiceImpl
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/17 11:22
 * @Version :1.0
 */
public class OrderServiceImpl implements IOrderService {


    public int createOrder(Order order) {
        OrderDao orderDao = new OrderDao();
        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);
    }

    public Long getCreateTime(Order order) {
       return order.getCreateTime();
    }
}
