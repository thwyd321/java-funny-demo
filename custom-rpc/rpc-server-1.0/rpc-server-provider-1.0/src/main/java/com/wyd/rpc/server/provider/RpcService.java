package com.wyd.rpc.server.provider;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName :RpcService
 * @Description : 使用此注解，声明一个类是rpc服务，并获取到该服务的interface 和 版本号
 * @Author : wangyudi
 * @Date : 2019/6/28 17:33
 * @Version :1.0
 */
@Target(ElementType.TYPE) //类/接口
@Retention(RetentionPolicy.RUNTIME)
@Component //被spring 扫描
public @interface RpcService {

    Class<?> value(); // 服务的接口

    String version() default "";//服务的版本号 默认为空

}
