package com.wyd.design.proxy.dynamic;

import com.wyd.design.proxy.statice2.entity.Order;
import com.wyd.design.proxy.dynamic.proxy.OrderSerivceDynamicProxy;
import com.wyd.design.proxy.statice2.service.IOrderService;
import com.wyd.design.proxy.statice2.service.impl.OrderServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName :DynamicStart
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/17 16:00
 * @Version :1.0
 */
public class Start {

    public static void main(String[] args) throws ParseException {

        Order order = new Order();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Date date = sdf.parse("2019/07/01");

        order.setCreateTime(date.getTime());

        OrderSerivceDynamicProxy orderSerivceDynamicProxy  = new OrderSerivceDynamicProxy();
        IOrderService orderService = (IOrderService) orderSerivceDynamicProxy.getProxy(new OrderServiceImpl());
        orderService.createOrder(order);
    }


}
