package com.wyd.design.singleton.hungry;

/**
 * @ClassName :HungrySingleton1
 * @Description :
 *
 * 饿汉式单例是在类加载的时候就立即初始化，并且创建单例对象。绝对线程安全，在线
 * 程还没出现以前就是实例化了，不可能存在访问安全问题。
 * 优点：没有加任何的锁、执行效率比较高，在用户体验上来说，比懒汉式更好。
 * 缺点：类加载的时候就初始化，不管用与不用都占着空间，浪费了内存，有可能占着茅
 * 坑不拉屎。
 *
 * @Author : wangyudi
 * @Date : 2019/7/16 10:19
 * @Version :1.0
 */
public class HungrySingleton1 {

    private static final HungrySingleton1 h;
    static {
        h=new HungrySingleton1();
    }
    private HungrySingleton1(){}

    public static HungrySingleton1 getInstance(){
        return h;
    }


}
