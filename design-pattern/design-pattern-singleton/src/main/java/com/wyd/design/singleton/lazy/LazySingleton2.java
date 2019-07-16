package com.wyd.design.singleton.lazy;

/**
 * @ClassName :LazySingleton2
 * @Description :
 * 双重检验
 * 
 * @Author : wangyudi
 * @Date : 2019/7/16 10:28
 * @Version :1.0
 */
public class LazySingleton2 {

    private static LazySingleton2 h;

    private LazySingleton2() {
    }

    public static LazySingleton2 getInstance() {
        if (h == null) {
            synchronized (LazySingleton2.class){
                if (h==null){
                    return new LazySingleton2();
                }
            }
        }
        return h;

    }


}
