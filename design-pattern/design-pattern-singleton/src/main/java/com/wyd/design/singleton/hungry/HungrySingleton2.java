package com.wyd.design.singleton.hungry;

/**
 * @ClassName :HungrySingleton2
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/16 10:22
 * @Version :1.0
 */
public class HungrySingleton2 {

    private static final HungrySingleton2 h = new HungrySingleton2();

    private HungrySingleton2(){}

    public static HungrySingleton2 getInstance(){
        return h;
    }

}
