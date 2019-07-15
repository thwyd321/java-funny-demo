package com.wyd.design.factory.abstracte;

/**
 * @ClassName :Client
 * @Description : 抽象工厂
 * @Author : wangyudi
 * @Date : 2019/7/15 16:59
 * @Version :1.0
 */
public class Client {

    public static void main(String[] args) {

        IPayFactory payFactory = new AlipayFactory();
        payFactory.createMobilePay().mobilePay();
        payFactory.createWebSitePay().webSitePay();



    }


}
