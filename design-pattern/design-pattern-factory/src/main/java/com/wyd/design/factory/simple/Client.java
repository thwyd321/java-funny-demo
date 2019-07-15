package com.wyd.design.factory.simple;

/**
 * @ClassName :Client
 * @Description : 简单工厂模式
 *         缺点：不符合开闭原则
 * @Author : wangyudi
 * @Date : 2019/7/15 16:40
 * @Version :1.0
 */
public class Client {

    public static void main(String[] args) {
        //-----------1.----------------------
        IPay pay1 = new AliPay();
        pay1.wakeUp();
        //-----------2.----------------------
        IPay pay2 = PayFactory.create("2");
        pay2.wakeUp();
    }

}
