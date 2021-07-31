package cnn.whoops.collection;

import org.junit.Test;
import sun.font.FontRunIterator;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author: whoops
 * @date: 2021/7/28 - 20:49
 * @description:
 *
 * 集合框架：
 *  Collection接口：单列结合，用来存储一个一个的对象
 *      List接口：存储有序的、可重复的数据
 *          ArrayList、LinkedList、Vector
 *      Set接口：存储无序的、不可重复的数据
 *          HashSet、LinkedHashSet、TreeAet
 *
 *  Map接口：双列集合，用来存储一对一对的数据（key - value）
 *          HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 *
 *
 */
public class CollectionTest {

    @Test
    public void test(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        // contains(Object obj):判断当前集合中是否 包含obj
        //在判断时会调用obj对象所在类的equals()方法
        System.out.println(coll.contains(123)); //true

        System.out.println(coll.contains(new String("Tom"))); //true

        System.out.println(coll.contains(new Person("Jerry", 20))); //true

        //containsAll(Collection coll1):判断形参coll1总的所有元素是否都存在当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1)); //true

    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        // remove(Object obj):从当前集合中移出除obj元素
        coll.remove(123);
        System.out.println(coll);

        //removeAll(Collection coll1):从当前集合中移除coll1中所有的元素（差集：共有的元素）
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //retainAll(Collection coll1):交集，获取当前集合和coll1集合的交集，并返回当前集合
        Collection coll1 = Arrays.asList(123,456);
        coll.retainAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //集合 ---> 数组 调用toArray()方法
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //数组 ---> 集合 调用Arrays类的静态方法asList()方法
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2
    }

    /**
     * 集合元素的遍历：使用迭代器Iterator接口
     */
    @Test
    public void test4(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        while (iterator.hasNext()){     //判断是否还有下一个元素
            System.out.println(iterator.next());
        }

        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

}
