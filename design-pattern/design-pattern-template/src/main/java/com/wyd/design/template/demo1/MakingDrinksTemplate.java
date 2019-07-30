package com.wyd.design.template.demo1;

/**
 * @ClassName :MakingDrinksTemplate
 * @Description : 制作饮料模板
 * @Author : wangyudi
 * @Date : 2019/7/30 14:23
 * @Version :1.0
 */
public abstract class MakingDrinksTemplate {



    public void make() {
        this.getWater();
        if (setHeatFlag()) {
            this.heatUpWater();
        }
        this.putinStock();
        this.stir();
        this.bottling();
    }
    //钩子方法：实现流程的微调
    public boolean setHeatFlag() {
        return false;
    }

    final void getWater() {
        System.out.println("接水");
    }

    final void heatUpWater() {
        System.out.println("烧水");
    }

    //放原料 抽象方法，由具体实现者实现
    abstract void putinStock();

    final void stir() {
        System.out.println("搅拌");
    }

    final void bottling() {
        System.out.println("装瓶");
    }
}
