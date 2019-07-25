package com.wyd.design.proxy.statice2;

import com.wyd.design.proxy.statice2.entity.Order;
import com.wyd.design.proxy.statice2.proxy.OrderServiceStaticProxy;
import com.wyd.design.proxy.statice2.service.IOrderService;
import com.wyd.design.proxy.statice2.service.impl.OrderServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName :Start
 * @Description :
 * 模拟根据订单日期切换数据源，通过代理模式，在代理方法中调用切换数据源的方法，并调用被代理的方法
 * @Author : wangyudi
 * @Date : 2019/7/17 11:40
 * @Version :1.0
 */
public class Start {


    public static void main(String[] args) throws ParseException {

        Order order = new Order();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Date date = sdf.parse("2019/07/01");

        order.setCreateTime(date.getTime());

        IOrderService orderService = new OrderServiceStaticProxy(new OrderServiceImpl());

        orderService.createOrder(order);
    }

}
