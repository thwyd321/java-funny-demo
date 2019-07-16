package com.wyd.design.prototype.simple;

/**
 * @ClassName :Start
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/16 11:47
 * @Version :1.0
 */
public class Start {

    public static void main(String[] args) {
        People people = new People();
        people.setSex("a");
        people.setName("fdf");
        people.setAge(1);
        People clone = (People) people.clone();
        System.out.println(clone.getSex());
    }


}
