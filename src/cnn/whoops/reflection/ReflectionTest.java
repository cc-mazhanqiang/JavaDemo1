package cnn.whoops.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author: whoops
 * @date: 2021/8/3 - 15:55
 * @description:
 */
public class ReflectionTest {
    @Test
    public void test() throws Exception {
        Class cla = Person.class;
        //通过反射，创建Person类的对象
        Constructor cons = cla.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Tom", 23);
        Person p = (Person) obj;
        System.out.println(p.toString());

        //通过反射，调用对象指定的属性和方法
        Field age = cla.getDeclaredField("age");
        age.set(p,20);
        System.out.println(p.toString());

        //通过反射，调用方法
        Method show = cla.getMethod("show");
        show.invoke(p);

        System.out.println("*******************************");
        //通过反射，可以调用Person类的私有结构：私有的构造器、属性、方法
        //私有的构造器
        Constructor ct = cla.getDeclaredConstructor(String.class);
        ct.setAccessible(true);
        Person p1 = (Person) ct.newInstance("Jack");
        System.out.println(p1);

        //私有的属性
        Field name = cla.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"zhangsan");
        System.out.println(p1);

        //私有的方法
        Method showNation = cla.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国");
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);
    }

    //获取Class的实例方式
    @Test
    public void test2() throws ClassNotFoundException {
        //1、调用运行时类的属性：.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //2、通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class personClass1 = person.getClass();
        System.out.println(personClass1);
        //3、调用Class的静态方法：forName(String classPath)  开发中比较常用
        Class forName = Class.forName("cnn.whoops.reflection.Person");
        System.out.println(forName);
        //4、使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class loadClass = classLoader.loadClass("cnn.whoops.reflection.Person");
        System.out.println(loadClass);
    }

    //使用Properties加载配置文件
    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        //方式一：配置文件需要在项目的目录下
        FileInputStream file = new FileInputStream("jdbc2.properties");
        properties.load(file);
        //方式二：配置文件需要在src目录下
//        ClassLoader loader = ReflectionTest.class.getClassLoader();
//        InputStream is = loader.getResourceAsStream("jdbc1.properties");
//        properties.load(is);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println("name = " + name + ",password = " + password);
    }
}
