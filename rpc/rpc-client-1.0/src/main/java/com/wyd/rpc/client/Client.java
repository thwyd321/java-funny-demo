package com.wyd.rpc.client;

import com.wyd.rpc.server.api.IHelloService;
import com.wyd.rpc.server.api.RpcRequest;
import com.wyd.rpc.server.api.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName :client
 * @Description : 客户端
 * @Author : wangyudi
 * @Date : 2019/7/1 14:30
 * @Version :1.0
 */
public class Client {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(12);
        user.setName("fasdfa");

        /**************静态代理****************/
        IHelloService helloService = HelloServiceProxy.getInstance("2.0");
        String result = helloService.hello("asdfasdfasddf");
        System.out.println(result);

        String s = helloService.saveUser(user);
        System.out.println(s);
        /**************动态代理****************/
        DynamicProxy dynamicProxy = new DynamicProxy("2.0");
        IHelloService helloService2 =  dynamicProxy.clientDynamicProxy(IHelloService.class,"localhost",8080);
        String aa = helloService2.saveUser(user);
        System.out.println(aa);


    }



}
