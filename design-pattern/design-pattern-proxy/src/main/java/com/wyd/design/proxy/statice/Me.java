package com.wyd.design.proxy.statice;

/**
 * @ClassName :Me
 * @Description : 被代理对象
 * @Author : wangyudi
 * @Date : 2019/7/16 16:13
 * @Version :1.0
 */
public class Me implements Person {
    public void findHouse() {
        System.out.println("被代理对象：没时间找房子，想要100平");
    }
}
