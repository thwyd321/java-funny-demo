package com.wyd.rpc.server.provider;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName :RpcServer
 * @Description : rpc服务端主服务，
 * 1。等待客户端连接
 * 2。把RpcService标记的类加载到 成员变量的map中保存起来
 * @Author : wangyudi
 * @Date : 2019/6/28 17:38
 * @Version :1.0
 */
@Component
public class RpcServer implements ApplicationContextAware, InitializingBean {

    private Map rpcMap = new HashMap();
    /**
     * 获取spring上下文，保存注解声明的类
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //1.获取被注解标记的类
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (serviceBeanMap.isEmpty()){
            serviceBeanMap.forEach((serviceName,serviceBean)->{
                //遍历serviceBeanMap，获取到每一个注解
                RpcService rpcServiceAnnotation = serviceBean.getClass().getAnnotation(RpcService.class);
                //获取到注解标记的类的接口名
                String name = rpcServiceAnnotation.value().getName();
                //获取到注解标记的类的版本号
                String version = rpcServiceAnnotation.version();
                //
                rpcMap.put(name+ Optional.ofNullable(version).orElse("_"+version),serviceBean);
            });
        }
    }

    public void afterPropertiesSet() throws Exception {

    }
}
