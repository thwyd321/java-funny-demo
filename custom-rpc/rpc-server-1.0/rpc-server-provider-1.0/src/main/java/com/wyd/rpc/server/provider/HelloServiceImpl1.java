package com.wyd.rpc.server.provider;

import com.wyd.rpc.server.api.IHelloService;
import com.wyd.rpc.server.api.User;

/**
 * @ClassName :HelloServiceImpl1
 * @Description : rpc服务端实现类
 *
 * @Author : wangyudi
 * @Date : 2019/6/28 17:30
 * @Version :1.0
 */
//使用注解 声明
@RpcService(value = IHelloService.class,version = "1.0")
public class HelloServiceImpl1 implements IHelloService {

    public String hello(String aa) {
        System.out.println(aa);
        return "你好";
    }

    public String saveUser(User user) {
        System.out.println(user);
        return "保存用户成功";
    }
}
