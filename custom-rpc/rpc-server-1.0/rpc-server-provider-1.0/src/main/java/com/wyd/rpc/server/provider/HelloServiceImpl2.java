package com.wyd.rpc.server.provider;

import com.wyd.rpc.server.api.IHelloService;
import com.wyd.rpc.server.api.User;

/**
 * @ClassName :HelloServiceImpl2
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/1 16:43
 * @Version :1.0
 */
@RpcService(value = IHelloService.class,version = "2.0")
public class HelloServiceImpl2 implements IHelloService {
    @Override
    public String hello(String aa) {
        return "你好 2.0";
    }

    @Override
    public String saveUser(User user) {
        System.out.println(user);
        System.out.println("2.0");
        return "2.0接口";
    }
}
