package com.wyd.design.strategy.demo1;

/**
 * @ClassName :WechatPay
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/30 13:56
 * @Version :1.0
 */
public class WechatPay implements Pay {
    public String wakeUp() {
        return "唤起微信支付";
    }
}
