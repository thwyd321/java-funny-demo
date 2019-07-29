package com.wyd.design.delegate.demo1;

/**
 * @ClassName :EmployeeB
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/29 15:22
 * @Version :1.0
 */
public class EmployeeB implements IEmployee {
    public void doing(String command) {
        System.out.println("我是员工B，现在开始做【"+command+"】");
    }
}
