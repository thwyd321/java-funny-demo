package com.wyd.design.factory.abstracte;

/**
 * @ClassName :AliWebSitePay
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 17:14
 * @Version :1.0
 */
public class AliWebSitePay implements IWebSitePay {
    public void webSitePay() {
        System.out.println("支付宝网站支付");
    }
}
