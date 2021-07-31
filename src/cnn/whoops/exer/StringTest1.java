package cnn.whoops.exer;

import org.junit.Test;

/**
 * @author: whoops
 * @date: 2021/7/27 - 16:41
 * @description:
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 */
public class StringTest1 {

    public int getCount(String fatStr,String subStr){
        int fatlength = fatStr.length();
        int sublength = subStr.length();
        int count = 0;//记录出现的次数
        int index = 0;//记录字符串出现的索引
        if (fatlength >= sublength){
            //  方式一：
//            while ((index = fatStr.indexOf(subStr)) != -1){
//                count++;
//                fatStr = fatStr.substring(index + subStr.length());     //当找到字符串之后，应该从该字符串的后面位置查找
//            }
            //  方式二：
            while ((index = fatStr.indexOf(subStr,index)) != -1){   //返回从指定位置开始，第一次出现子字符串的索引
                count++;
                index += sublength; //表示跳过找到的位置的索引
            }
            return count;
        }else{
            return 0;
        }
    }

    @Test
    public void testGetCount(){
        String fatStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount(fatStr, subStr);
        System.out.println(count);
    }

}
