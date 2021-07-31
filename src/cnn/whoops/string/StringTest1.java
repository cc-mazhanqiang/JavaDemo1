package cnn.whoops.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author: whoops
 * @date: 2021/7/26 - 22:00
 * @description:
 */
public class StringTest1 {

    /**
     *  String 与 char[] 之间的转换
     *
     *  String ---> char[]：调用String的toCharArray()
     *  char[] ---> String: 调用String的构造器
     */
    @Test
    public void test(){
        String str = "abc123"; // 题目：反转输出：a21cb3

        String str1 = "";
        str1 += str.substring(0,1);
//        System.out.println(str1);

        String str3 = "";
        str3 += str.substring(5);
//        System.out.println(str3);

        String str2 = "";
        for (int i = 4; i >= 1; i--) {
          str2 += str.charAt(i);
        }

        String strs = "";
        strs = str1 + str2 +str3;

        System.out.println(strs);

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String s = new String(arr);
        System.out.println(s);

    }

    /**
     * String 与 byte[] 之间的转换
     *
     * String ---> byte[]：调用String的getByte()  --->编码
     *
     * byte[] ---> String:调用String的构造器  --->解码
     */
    @Test
    public void test1() throws UnsupportedEncodingException {
        String str = "abc123中国";
        byte[] bytes = str.getBytes();  // 默认编码集UTF-8
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        String s1 = new String(gbks,"gbk");
        System.out.println(s1);

        String s = new String(bytes);
        System.out.println(s);

    }

}
