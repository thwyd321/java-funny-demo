package com.wyd.design.proxy.statice;

/**
 * @ClassName :Start
 * @Description :
 * 静态代理模式，被代理对象：Me
 *              代理对象: Agent
 *
 * 使用代理模式主要有两个目的：一保护目标对象，二增强目标对象
 * @Author : wangyudi
 * @Date : 2019/7/16 16:15
 * @Version :1.0
 */
public class Start {

    public static void main(String[] args) {
        Agent agent = new Agent(new Me());
        agent.findHouse();
    }

}
