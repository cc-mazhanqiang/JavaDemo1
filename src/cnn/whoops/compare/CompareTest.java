package cnn.whoops.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: whoops
 * @date: 2021/7/28 - 11:19
 * @description:
 *
 * Comparable、Comparator接口用于比较两个对象的大小
 * 前者是类直接去实现Comparable接口的compare()方法，如：自定义类
 * 后者是临时性的比较，如下：
 *
 */
public class CompareTest {

    @Test
    public void test(){

        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};

        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 =(String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2); //从大到小进行排序
                }
                throw new RuntimeException("输入的数据不一致！");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

}
