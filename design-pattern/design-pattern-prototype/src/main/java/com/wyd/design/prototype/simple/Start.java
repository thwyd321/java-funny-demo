package com.wyd.design.prototype.simple;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName :Start
 * @Description :
 *
 *  浅克隆，对象中的引用类型的地址在克隆后是同一个
 * @Author : wangyudi
 * @Date : 2019/7/16 11:47
 * @Version :1.0
 */
public class Start {

    public static void main(String[] args) throws Exception {
        People people = new People();
        people.setSex("ddd");
        people.setName("fdf");
        people.setAge(1);

        List list = new ArrayList();

        list.add("2");

        people.setHobbies(list);


        People clone = (People) people.clone();
        System.out.println(people.getHobbies() == clone.getHobbies());

    }


}
