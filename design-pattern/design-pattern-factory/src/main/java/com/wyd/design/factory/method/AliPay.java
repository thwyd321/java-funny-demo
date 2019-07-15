package com.wyd.design.factory.method;


/**
 * @ClassName :AliPay
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 16:38
 * @Version :1.0
 */
public class AliPay implements IPay {
    public void wakeUp() {
        System.out.println("唤起支付宝支付");
    }
}
