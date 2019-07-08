package com.wyd.rpc.server.api;

/**
 * @ClassName :IHelloService
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/6/28 17:24
 * @Version :1.0
 */
public interface IHelloService {

    String hello(String aa);

    String saveUser(User user);

}
