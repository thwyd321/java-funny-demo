package com.wyd.design.factory.method;

/**
 * @ClassName :WechatPayFactory
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 16:53
 * @Version :1.0
 */
public class WechatPayFactory implements IPayFactory {
    public IPay create() {
        return new WechatPay();
    }
}
