package com.wyd.design.strategy.demo1;

/**
 * @ClassName :Alipay
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/30 13:56
 * @Version :1.0
 */
public class Alipay implements Pay {
    public String wakeUp() {
        return "唤起支付宝支付";
    }
}
