package com.wyd.design.strategy.demo1;

/**
 * @ClassName :Start
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/30 13:57
 * @Version :1.0
 */
public class Start {

    public static void main(String[] args) {
        //1
        PayStrategy payStrategy = new PayStrategy(new Alipay());
        String pay = payStrategy.pay();
        System.out.println(pay);
        //2
        String s = PayStrategyFactory.getBean("2").wakeUp();
        System.out.println(s);


    }

}
