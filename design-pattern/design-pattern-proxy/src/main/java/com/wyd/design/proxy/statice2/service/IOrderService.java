package com.wyd.design.proxy.statice2.service;


import com.wyd.design.proxy.statice2.entity.Order;

/**
 * @ClassName :IOrderService
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/17 11:21
 * @Version :1.0
 */
public interface IOrderService {
    int createOrder(Order order);
}
