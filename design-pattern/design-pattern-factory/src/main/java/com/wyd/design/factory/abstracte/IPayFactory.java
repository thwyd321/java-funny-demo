package com.wyd.design.factory.abstracte;


/**
 * @ClassName :IPayFactory
 * @Description : 支付工厂，有手机支付，二维码支付
 * @Author : wangyudi
 * @Date : 2019/7/15 16:51
 * @Version :1.0
 */
public interface IPayFactory {

    IMobilePay createMobilePay();
    IWebSitePay createWebSitePay();



}
