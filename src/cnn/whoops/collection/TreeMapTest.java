package cnn.whoops.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author: whoops
 * @date: 2021/7/29 - 22:37
 * @description:
 */
public class TreeMapTest {

    //自然排序
    @Test
    public void test() {

        TreeMap map = new TreeMap();
        User user1 = new User("Tom", 23);
        User user2 = new User("Jerry", 32);
        User user3 = new User("Jack", 20);
        User user4 = new User("Rose", 18);

        map.put(user1,98);
        map.put(user2,87);
        map.put(user3,76);
        map.put(user4,100);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "==" + entry.getValue());

        }

    }

    //定制排序
    @Test
    public void test2() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User user = (User) o1;
                    User user1 = (User) o2;
                    return -Integer.compare(user.getAge(), user1.getAge());
                }
                throw new RuntimeException("输入的类型不一致！");
            }
        });
        User user1 = new User("Tom", 23);
        User user2 = new User("Jerry", 32);
        User user3 = new User("Jack", 20);
        User user4 = new User("Rose", 18);

        map.put(user1, 98);
        map.put(user2, 87);
        map.put(user3, 76);
        map.put(user4, 100);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "==" + entry.getValue());
        }
    }
}
