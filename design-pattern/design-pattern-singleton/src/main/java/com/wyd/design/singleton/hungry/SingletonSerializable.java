package com.wyd.design.singleton.hungry;

import java.io.Serializable;

/**
 * @ClassName :SingletonSerializable
 * @Description :
 * 序列化破坏单例
 * @Author : wangyudi
 * @Date : 2019/7/16 10:44
 * @Version :1.0
 */
public class SingletonSerializable implements Serializable {

    private static SingletonSerializable singletonSerializable = new SingletonSerializable();

    private SingletonSerializable(){}

    public static SingletonSerializable getInstance(){
        return singletonSerializable;
    }


    public static void main(String[] args) {
        SingletonSerializable s1 = null;
        SingletonSerializable s2 = SingletonSerializable.getInstance();



        System.out.println(s2);

    }
}
