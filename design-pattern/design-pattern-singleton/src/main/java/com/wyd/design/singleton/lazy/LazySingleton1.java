package com.wyd.design.singleton.lazy;

/**
 * @ClassName :LazySingleton1
 * @Description :
 * 在静态方法上加锁
 * @Author : wangyudi
 * @Date : 2019/7/16 10:25
 * @Version :1.0
 */
public class LazySingleton1 {

    private static LazySingleton1 lazySingleton1;

    private LazySingleton1(){

    }
    public static synchronized LazySingleton1 getInstance(){

        if (lazySingleton1 == null){
            return new LazySingleton1();
        }
        return lazySingleton1;
    }

}
