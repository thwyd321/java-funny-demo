package com.wyd.design.factory.abstracte;

/**
 * @ClassName :AlipayFactory
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 17:18
 * @Version :1.0
 */
public class AlipayFactory implements IPayFactory {
    public IMobilePay createMobilePay() {
        return new AliMoblilePay();
    }

    public IWebSitePay createWebSitePay() {
        return new AliWebSitePay();
    }
}
