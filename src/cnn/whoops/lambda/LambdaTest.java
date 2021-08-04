package cnn.whoops.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author: whoops
 * @date: 2021/8/4 - 21:52
 * @description:
 *
 * Lambda表达式的使用举例
 *
 */
public class LambdaTest {
    @Test
    public void test() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱中国");
            }
        };
        r.run();

        System.out.println("*************************");

        Runnable r1 = () -> System.out.println("我爱中国");
        r1.run();

        System.out.println("**************************");

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare = comparator.compare(30, 12);
        System.out.println(compare);

        //Lambda表达式
        System.out.println("****************************");
        Comparator<Integer> comparator1 = (o1,o2) -> Integer.compare(o1,o2);
        int compare1 = comparator.compare(30, 12);
        System.out.println(compare1);

        System.out.println("****************************");
        //方法的引用
        Comparator<Integer> comparator2 = Integer :: compare;
        int compare2 = comparator.compare(30, 12);
        System.out.println(compare2);

    }

}
