package com.wyd.design.delegate.demo1;

/**
 * @ClassName :EmployeeA
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/29 15:21
 * @Version :1.0
 */
public class EmployeeA implements IEmployee {
    public void doing(String command) {
        System.out.println("我是员工A，现在开始做【"+command+"】");
    }
}
