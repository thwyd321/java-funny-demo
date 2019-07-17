package com.wyd.design.proxy.statice;

/**
 * @ClassName :Agent
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/16 16:14
 * @Version :1.0
 */
public class Agent {

    private Person me;

    public Agent(Person me) {
        this.me = me;
    }

    public void findHouse(){
        System.out.println("代理对象：请提出需求");
        me.findHouse();
        System.out.println("代理对象：找到了，请交钱");
    }

}
