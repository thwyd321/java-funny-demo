package com.wyd.design.prototype.deep;

import com.wyd.design.prototype.simple.People;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName :Start
 * @Description :
 *
 *  深克隆，将对象序列化再反序列化，对象中的引用类型的地址不再相同。
 * @Author : wangyudi
 * @Date : 2019/7/16 11:47
 * @Version :1.0
 */
public class Start {

    public static void main(String[] args) throws Exception {
        People people = new People();
        people.setSex("a");
        people.setName("fdf");
        people.setAge(1);
        List list = new ArrayList();
        list.add("1");
        people.setHobbies(list);


        People clone = (People) people.clone();
        System.out.println(people.getHobbies() == clone.getHobbies());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(people);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        People people2 = (People) ois.readObject();


        System.out.println(people.getHobbies() == people2.getHobbies());


    }


}
