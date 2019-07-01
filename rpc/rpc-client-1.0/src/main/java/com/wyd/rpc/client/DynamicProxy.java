package com.wyd.rpc.client;

import com.wyd.rpc.server.api.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName :DynamicProxy
 * @Description : 客户端动态代理
 * @Author : wangyudi
 * @Date : 2019/7/1 17:10
 * @Version :1.0
 */
public class DynamicProxy {
    private String version;

    public DynamicProxy(String version) {
        this.version = version;
    }

    /**
     * 使用jdk动态代理，服务端的api改变不用改代码
     * @param interfaceClass
     * @param host
     * @param port
     * @param <T>
     * @return
     */
    public <T> T clientDynamicProxy(final Class interfaceClass, String host, int port){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                RpcRequest rpcRequest = new RpcRequest();
                rpcRequest.setVersion(version);
                rpcRequest.setClassName(interfaceClass.getName());
                rpcRequest.setMethodName(method.getName());
                rpcRequest.setParameters(args);
                return send(rpcRequest);
            }
        });
    }

    /**
     * 客户端与服务端建立Socket通信
     * @param rpcRequest
     * @return
     */
    public Object send(RpcRequest rpcRequest) {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        Object result = null;
        try {
            Socket socket = new Socket("localhost", 8080);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();

            objectInputStream = new ObjectInputStream(socket.getInputStream());
            result = objectInputStream.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }

}
