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
        IHelloService helloService = HelloServiceProxy.getInstance("2.0");
        /*String result = helloService.hello("asdfasdfasddf");
        System.out.println(result)*/;
        User user = new User();
        user.setAge(12);
        user.setName("fasdfa");
        String s = helloService.saveUser(user);
        System.out.println(s);


    }



}
