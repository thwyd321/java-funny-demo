package com.wyd.design.singleton.hungry;

import java.io.*;

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
    /**
     * 将本单例序列化后再反序列化，将会破坏单例
     * 解决办法：注释部分代码
     * 看源码 ObjectInputStream 通过反射调用了该方法，如果该方法不为空则返回该方法的对象
     * @param args
     * @throws Exception
     */
    /*private Object readResolve(){
        return singletonSerializable;
    }*/

    public static void main(String[] args) throws Exception {
        SingletonSerializable s1 = null;
        SingletonSerializable s2 = SingletonSerializable.getInstance();

        FileOutputStream fileOutputStream = new FileOutputStream("SingletonSerializable.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(s2);
        oos.flush();
        oos.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("SingletonSerializable.obj");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        s1 = (SingletonSerializable) ois.readObject();
        ois.close();
        fileInputStream.close();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);

    }
}
