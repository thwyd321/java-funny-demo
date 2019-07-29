package com.wyd.design.delegate.demo1;

/**
 * @ClassName :Boss
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/29 15:28
 * @Version :1.0
 */
public class Boss {

    public void commond(String commond,Leader leader){
        leader.doing(commond);
    }


}
