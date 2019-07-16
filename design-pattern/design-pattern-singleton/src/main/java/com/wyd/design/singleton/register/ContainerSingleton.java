package com.wyd.design.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName :ContainerSingleton
 * @Description : 容器注册式单例
 * @Author : wangyudi
 * @Date : 2019/7/16 11:21
 * @Version :1.0
 */
public class ContainerSingleton {

    private ContainerSingleton(){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        synchronized (ioc){
            if (!ioc.containsKey(className)){
                ioc.put(className,Class.forName(className).newInstance());
            }
            return ioc.get(className);
        }
    }

    public static void main(String[] args) throws Exception {
        Object bean1 = ContainerSingleton.getBean("com.wyd.design.singleton.register.ContainerSingleton");
        System.out.println(bean1);
        Object bean2 = ContainerSingleton.getBean("com.wyd.design.singleton.register.ContainerSingleton");
        System.out.println(bean2);
    }

}
