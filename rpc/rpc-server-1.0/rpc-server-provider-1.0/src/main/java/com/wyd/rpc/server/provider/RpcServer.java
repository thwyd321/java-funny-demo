package com.wyd.rpc.server.provider;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private int port;
    private Map rpcMap = new HashMap();
    ExecutorService executorService = Executors.newCachedThreadPool();

    public RpcServer(int port) {
        this.port = port;
    }

    /**
     * 获取spring上下文，保存注解声明的类
     *
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //1.获取被注解标记的类
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (!serviceBeanMap.isEmpty()) {
            for(Object servcieBean:serviceBeanMap.values()){
                //拿到注解
                RpcService rpcService=servcieBean.getClass().getAnnotation((RpcService.class));
                String serviceName=rpcService.value().getName();//拿到接口类定义,com.wyd.rpc.server.api.IHelloService
                String version=rpcService.version(); //拿到版本号
                if(!StringUtils.isEmpty(version)){
                    serviceName+="-"+version;
                }
                rpcMap.put(serviceName,servcieBean);
            }
        }
    }

    /**
     * spring初始化时  setApplicationContext方法执行后会执行此方法
     * 通过accept方法阻塞等待客户端连接，获取到连接后启线程处理
     * @throws IOException
     */
    public void afterPropertiesSet() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            executorService.execute(new RequestHandler(socket,rpcMap));
        } catch (Exception e) {

        } finally {
            if (serverSocket != null) {
                serverSocket.close();

            }
        }


    }
}
