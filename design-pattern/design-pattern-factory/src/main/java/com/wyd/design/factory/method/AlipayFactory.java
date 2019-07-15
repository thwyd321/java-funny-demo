package com.wyd.design.factory.method;

/**
 * @ClassName :AlipayFactory
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/15 16:53
 * @Version :1.0
 */
public class AlipayFactory implements IPayFactory {

    public IPay create() {
        return new AliPay();
    }

}
