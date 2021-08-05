package cnn.whoops.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author: whoops
 * @date: 2021/8/5 - 10:05
 * @description:
 *
 * Java内置四大核心函数式接口：
 * 消费型接口：Consumer<T>            void accept(T t)
 * 供给型接口：Supplier<T>            T get()
 * 函数型接口：Function<T,R>          R apply(T t)
 * 断定型接口：Predicate<T>           boolean test(T t)
 *
 */
public class LambdaTest2 {
    @Test
    public void test(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("一双鞋子的价格为：" + aDouble);
            }
        });

        System.out.println("*********************************");

        happyTime(400,money -> System.out.println("一件衣服的价格为：" + money));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);

    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","东京","上海");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(list1);
        System.out.println("****************************");

        List<String> list2 = filterString(list,s -> s.contains("京"));
        System.out.println(list2);

    }
    //根据给定的规则，过滤集合中的字符串
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

}
