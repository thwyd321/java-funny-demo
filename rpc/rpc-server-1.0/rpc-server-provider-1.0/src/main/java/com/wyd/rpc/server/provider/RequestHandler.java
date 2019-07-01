package com.wyd.rpc.server.provider;

import com.wyd.rpc.server.api.RpcRequest;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * @ClassName :RequestHandler
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/1 11:28
 * @Version :1.0
 */
public class RequestHandler implements Runnable {
    private Map rpcMap;
    private Socket socket;

    public RequestHandler(Socket socket, Map rpcMap) {
        this.rpcMap = rpcMap;
        this.socket = socket;
    }

    /**
     *
     */
    @Override
    public void run() {
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            //客户端与服务端进行信息交互时，固定使用RpcRequest对象
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            //获取到客户端传递的信息后，使用反射调用方法，并返回给客户端结果
            Object result = invoke(rpcRequest);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param rpcRequest
     * @return
     */
    private Object invoke(RpcRequest rpcRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        String className = rpcRequest.getClassName();//客户端调用的接口名
        String version = rpcRequest.getVersion();//客户端调用的版本号
        String methodName = rpcRequest.getMethodName();//客户端调用的方法名
        Object[] parameters = rpcRequest.getParameters();//客户端的请求参数
        if (!StringUtils.isEmpty(version)) {
            className += "-" + version;
        }
        //通过客户端调用的className和version 从容器初始化时加载map中取出bean
        Object serviceBean = rpcMap.get(className);
        Object result = null;
        Method method = null;
        if (parameters != null) {
            //遍历得到每个参数的类型
            Class [] types = new Class[parameters.length];
            for (int i=0;i<parameters.length;i++) {
                types[i] = parameters[i].getClass();
            }
            //types 参数类型
            method = serviceBean.getClass().getMethod(methodName, types);
        } else {
            method = serviceBean.getClass().getMethod(methodName);

        }

        result = method.invoke(serviceBean, parameters);

        return result;
    }
}
