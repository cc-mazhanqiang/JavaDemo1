package cnn.whoops.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author: whoops
 * @date: 2021/8/5 - 15:38
 * @description:
 *
 * lambda表达式的使用举例
 *
 * lambda表达式的本质：作为函数式接口的实例
 *
 */
public class LambdaTest1 {
    @Test
    public void test(){
        //语法格式一：无参，无返回值
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱中国");
            }
        };
        r.run();
        System.out.println("***************************");

        Runnable r1 = () -> System.out.println("我爱北京");
        r1.run();
    }

    //语法格式二：Lambda 需要一个参数，但是没有返回值
    @Test
    public void test1(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("中国");

        System.out.println("****************************");
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("北京");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test2(){
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("北京");
    }

    //语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test3(){
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("北京");
        System.out.println("****************************");
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("北京");
    }

    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test4() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com.compare(32, 30));
        System.out.println("*****************************");
        Comparator<Integer> com1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(26, 23));
    }

    //语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test5(){
        Comparator<Integer> com1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println("*****************************");
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(26, 23));
    }
}
