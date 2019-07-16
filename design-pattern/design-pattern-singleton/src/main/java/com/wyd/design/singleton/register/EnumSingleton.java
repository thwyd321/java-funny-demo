package com.wyd.design.singleton.register;

/**
 * @ClassName :EnumSingleton
 * @Description : 注册式单例
 * @Author : wangyudi
 * @Date : 2019/7/16 10:58
 * @Version :1.0
 */
public enum EnumSingleton {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());
        System.out.println(instance.getData());

        EnumSingleton instance2 = EnumSingleton.getInstance();
        System.out.println(instance2.getData());
    }

}
