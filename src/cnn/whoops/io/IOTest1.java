package cnn.whoops.io;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: whoops
 * @date: 2021/7/31 - 22:17
 * @description:
 *
 * 获取文本文件中每个字符出现的次数
 * 思路：
 * 1.遍历文本每一个字符
 * 2.字符出现的次数存在Map中
 */
public class IOTest1 {

    @Test
    public void test(){
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader("dbcp.txt");
            bw = new BufferedWriter(new FileWriter("WordCount.txt"));

            //创建map集合
            Map<Character, Integer> map = new HashMap<>();

            //遍历每一个字符，每一个字符出现的次数放到map集合中
            int count = 0;
            while ((count = fr.read()) != -1){
                char ch = (char) count;     //把 int 型 count 强转为 char型
                //判断 ch 是否在map中第一次出现
                if (map.get(ch) == null){
                    map.put(ch,1);
                }else{
                    //map.get(Object obj)获取指定key的value
                    map.put(ch,map.get(ch) + 1);
                }
            }

            //遍历map集合，再写入数据
            Set<Map.Entry<Character, Integer>> set = map.entrySet();
            for (Map.Entry<Character, Integer> entry : set) {
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t'://\t表示tab 键字符
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r'://
                        bw.write("回车=" + entry.getValue());
                        break;
                    case '\n'://
                        bw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bw.newLine();
            }

            System.out.println("数据统计成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
