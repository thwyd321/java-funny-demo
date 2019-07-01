package com.wyd.rpc.server.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName :Start
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/1 13:14
 * @Version :1.0
 */
public class Start {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        ((AnnotationConfigApplicationContext) context).start();
    }

}
