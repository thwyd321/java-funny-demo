package com.wyd.design.factory.abstracte;

/**
 * @ClassName :WechatWebSitePay
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 17:14
 * @Version :1.0
 */
public class WechatWebSitePay implements IWebSitePay {
    public void webSitePay() {
        System.out.println("微信网站支付");
    }
}
