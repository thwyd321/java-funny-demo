package com.wyd.design.factory.method;

/**
 * @ClassName :Client
 * @Description : 工厂方法
 * @Author : wangyudi
 * @Date : 2019/7/15 16:47
 * @Version :1.0
 */
public class Client {
    public static void main(String[] args) {

        IPayFactory payFactory = new AlipayFactory();
        payFactory.create().wakeUp();


    }
}
