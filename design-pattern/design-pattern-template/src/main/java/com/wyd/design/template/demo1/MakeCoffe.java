package com.wyd.design.template.demo1;

import sun.nio.cs.ext.MacArabic;

/**
 * @ClassName :MakeCoffe
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/30 14:32
 * @Version :1.0
 */
public class MakeCoffe extends MakingDrinksTemplate {
    void putinStock() {
        System.out.println("放入咖啡");
    }

    //钩子方法：实现流程的微调
    @Override
    public boolean setHeatFlag() {
        return false;
    }

    public static void main(String[] args) {
        MakeCoffe makeCoffe = new MakeCoffe();
        makeCoffe.make();
    }

}
