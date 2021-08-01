package cnn.whoops.io;

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
    private int age;

    public Person() {
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
}
