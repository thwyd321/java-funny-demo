package com.wyd.design.delegate.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName :Leader
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/29 15:26
 * @Version :1.0
 */
public class Leader implements IEmployee {

    private Map<String,IEmployee> targets = new HashMap<String, IEmployee>();



    public Leader() {
        targets.put("注册",new EmployeeA());
        targets.put("登陆",new EmployeeB());
    }

    public void doing(String command) {
        targets.get(command).doing(command);
    }



}
