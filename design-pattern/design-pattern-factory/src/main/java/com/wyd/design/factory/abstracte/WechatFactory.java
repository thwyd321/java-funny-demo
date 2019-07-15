package com.wyd.design.factory.abstracte;

/**
 * @ClassName :WechatFactory
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 17:16
 * @Version :1.0
 */
public class WechatFactory implements IPayFactory {
    public IMobilePay createMobilePay() {
        return new WechatMobliePay();
    }

    public IWebSitePay createWebSitePay() {
        return new WechatWebSitePay();
    }


}
