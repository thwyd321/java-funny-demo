package com.wyd.design.factory.simple;

/**
 * @ClassName :PayFactory
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 16:40
 * @Version :1.0
 */
public class PayFactory {

    public static IPay create(String payChannel) {

        if ("1".equals(payChannel)) {
            return new AliPay();
        } else if ("2".equals(payChannel)) {
            return new WechatPay();
        }
        return null;

    }


}
