package cnn.whoops.reflection;

import java.io.Serializable;

/**
 * @author: whoops
 * @date: 2021/8/1 - 16:10
 * @description:
 */
public class Person implements Serializable {
    //可序列化标识
    private static final long serialVersionUID = 6844667710L;

    private String name;
    int age;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("我是一个中国人");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
}
