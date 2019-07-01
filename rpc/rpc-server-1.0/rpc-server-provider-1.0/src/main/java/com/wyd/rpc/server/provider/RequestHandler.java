package com.wyd.rpc.server.provider;

import java.net.Socket;
import java.util.HashMap;
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

    @Override
    public void run() {

    }
}
