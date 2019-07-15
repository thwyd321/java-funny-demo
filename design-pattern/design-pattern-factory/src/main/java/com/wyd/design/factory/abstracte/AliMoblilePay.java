package com.wyd.design.factory.abstracte;



/**
 * @ClassName :AliPay
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 16:38
 * @Version :1.0
 */
public class AliMoblilePay implements IMobilePay {

    public void mobilePay() {
        System.out.println("支付宝手机支付");
    }
}
