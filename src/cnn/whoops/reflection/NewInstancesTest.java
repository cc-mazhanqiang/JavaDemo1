package cnn.whoops.reflection;

import org.junit.Test;

/**
 * @author: whoops
 * @date: 2021/8/3 - 22:03
 * @description:
 */
public class NewInstancesTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        //调用 newInstance()方法，创建对应的运行时的对象，调用的是空参的构造器
        Person person = personClass.newInstance();
        System.out.println(person);
    }
}
