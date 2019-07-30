package com.wyd.design.strategy.demo1;

/**
 * @ClassName :PayMethod
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/30 13:57
 * @Version :1.0
 */
public class PayStrategy {
    private Pay pay;

    public PayStrategy(Pay pay) {
        this.pay = pay;
    }

    public String pay(){
        return pay.wakeUp();
    }

}
