package abb.pattern.test;

/**
 * @className: abb.pattern.test.SingletonTest
 * @author: sir
 * @description: TODO
 * @date: 2021/5/23 - 21:25
 */
public class SingletonTest {

    public static void main(String[] args) {

        Student student = Student.getStu();
        Student student1 = Student.getStu();
        System.out.println(student == student1);

    }
}

//饿汉模式 --> 线程安全的
class Student{

    //1、私有化类的构造器
    private Student(){

    }

    //2、内部创建类的对象（静态的）
    private static Student stu = new Student();

    //懒汉模式
//    private static Student stu = null;

   /* //当前线程是不安全的
    private  static Student getStu(){
        if (stu == null){
            stu = new Student();
        }
        return stu;
    }*/

    //3、提供公共的静态的方法，返回类的对象
    public static Student getStu(){
        return stu;
    }

}
