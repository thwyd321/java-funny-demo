package com.wyd.design.prototype.simple;

import java.util.List;

/**
 * @ClassName :People
 * @Description :
 * @Author : wangyudi
 * @Date : 2019/7/16 11:45
 * @Version :1.0
 */
public class People implements ProtoType {

    private int age;
    private String name;
    private String sex;
    private List hobbies;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    public ProtoType clone() {
        People people = new People();
        people.setAge(this.getAge());
        people.setName(this.getName());
        people.setSex(this.getSex());
        people.setHobbies(this.getHobbies());
        return people;
    }
}
