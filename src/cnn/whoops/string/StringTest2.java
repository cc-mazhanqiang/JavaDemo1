package cnn.whoops.string;

/**
 * @author: whoops
 * @date: 2021/7/26 - 23:12
 * @description:
 */

import org.junit.Test;

/**
 * 结论：
 * 1.常量和常量的拼接结果在常量池，且常量池中不会存在相同内容的常量。
 * 2.只要其中有一个是常量，结果就在堆中。
 * 3.如果拼接的结果调用intern()方法，返回值就在常量池中。
 */
public class StringTest2 {

    @Test
    public void test(){
        String s1 = "javaEE";
        String s2 = "java";
        String s3 = s2 + "EE";  //s3在堆中
        System.out.println(s1 == s3);

        final String s4 = "java"; // final修饰的s4是一个常量
        String s5 = s4 + "EE";
        System.out.println(s1 == s5);
    }

}
