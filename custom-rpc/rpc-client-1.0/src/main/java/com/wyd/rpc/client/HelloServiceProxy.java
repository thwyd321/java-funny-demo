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
 * @ClassName :IHelloServiceProxy
 * @Description : 第一版本，使用静态代理
 * @Author : wangyudi
 * @Date : 2019/7/1 15:53
 * @Version :1.0
 */
public class HelloServiceProxy implements IHelloService {

    private static String version;

    private RpcRequest rpcRequest = new RpcRequest(IHelloService.class.getName(),null,null,version);
    /**
     * 由外部传入 version值
     * @param version
     * @return
     */
    public static HelloServiceProxy getInstance(String version) {
        HelloServiceProxy.version = version;
        return new HelloServiceProxy();
    }

    public String hello(String aa) {
        rpcRequest.setMethodName("hello");
        rpcRequest.setParameters(new Object[]{aa});

        return (String) send(rpcRequest);
    }

    public String saveUser(User user) {
        rpcRequest.setMethodName("saveUser");
        rpcRequest.setParameters(new Object[]{user});

        return (String) send(rpcRequest);
    }


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
