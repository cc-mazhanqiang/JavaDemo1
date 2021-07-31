package cnn.whoops.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author: whoops
 * @date: 2021/7/31 - 9:57
 * @description:
 */
public class MapTest2 {
    @Test
    public void test(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tom",23);
        map.put("zhangsan",20);
        map.put("Jerry",25);
        map.put("Jack",30);
        map.put("Mery",12);

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }

        Collection<Integer> values = map.values();
//        for (Integer value : values) {
//            System.out.println(value);
//        }
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        for (Map.Entry<String, Integer> entry : entries) {
//            System.out.println(entry);
//        }
        Iterator<Map.Entry<String,Integer>> entry = entries.iterator();
        while (entry.hasNext()){
            Map.Entry<String, Integer> entry1 = entry.next();
            String key = entry1.getKey();
            Integer value = entry1.getValue();
            System.out.println(key + "=" + value);
        }

        System.out.println("*****************************");

        MapTest2 mt = new MapTest2();
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Tom","23");
        map1.put("zhangsan","20");
        map1.put("Jerry","25");
        map1.put("Jack","30");
        map1.put("Mery","12");
        List<String> value = mt.getValue(map1);
//        System.out.println(value);

        Iterator<String> iterator1 = value.iterator();
        while (iterator1.hasNext()){
            String next = iterator1.next();
            System.out.println(next);
        }


    }

    public List<String> getValue(HashMap<String,String> map){
        ArrayList<String> list = new ArrayList<>();
        Collection<String> values = map.values();
        for (String value : values) {
            list.add(value);
        }
        return list;
    }
}
