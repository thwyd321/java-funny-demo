package com.wyd.design.factory.simple;

/**
 * @ClassName :WechatPay
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 16:39
 * @Version :1.0
 */
public class WechatPay implements IPay {
    public void wakeUp() {
        System.out.println("唤起微信支付");
    }
}
