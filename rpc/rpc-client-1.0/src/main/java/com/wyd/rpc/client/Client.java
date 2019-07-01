package com.wyd.rpc.client;

import com.wyd.rpc.server.api.IHelloService;
import com.wyd.rpc.server.api.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName :client
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/1 14:30
 * @Version :1.0
 */
public class Client {

    public static void main(String[] args) {
        /*IHelloService helloService = null;
        helloService.hello("aa");*/
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(IHelloService.class.getName());
        rpcRequest.setMethodName("hello");
        rpcRequest.setVersion("1.0");
        Object [] objects = new Object[]{"123"};
        rpcRequest.setParameters(objects);

        Object result = send(rpcRequest);
        System.out.println(result);
    }

    public static Object send(RpcRequest rpcRequest) {
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
