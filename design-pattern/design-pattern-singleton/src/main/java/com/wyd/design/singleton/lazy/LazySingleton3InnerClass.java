package com.wyd.design.singleton.lazy;

/**
 * @ClassName :LazySingleton3InnerClass
 * @Description :
 * 静态内部类
 * @Author : wangyudi
 * @Date : 2019/7/16 10:36
 * @Version :1.0
 */
public class LazySingleton3InnerClass {

    private static class InnerClass{
        private static final LazySingleton3InnerClass l = new LazySingleton3InnerClass();
    }

    private LazySingleton3InnerClass(){
        if (InnerClass.l!=null){
            throw new RuntimeException("防止反射破坏单例");
        }
    }
    public static LazySingleton3InnerClass getInstance(){
        return InnerClass.l;
    }

}
