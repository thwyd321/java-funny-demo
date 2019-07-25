package com.wyd.design.proxy.statice2.dao;

import com.wyd.design.proxy.statice2.entity.Order;

/**
 * @ClassName :OrderDao
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/17 11:19
 * @Version :1.0
 */
public class OrderDao {

    public int insert(Order order){
        System.out.println("OrderDao 创建订单成功");
        return 1;
    }

}
