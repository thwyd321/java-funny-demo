package com.wyd.design.factory.abstracte;



/**
 * @ClassName :WechatPay
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 16:39
 * @Version :1.0
 */
public class WechatMobliePay implements IMobilePay {
    public void mobilePay() {
        System.out.println("微信手机支付");
    }
}
