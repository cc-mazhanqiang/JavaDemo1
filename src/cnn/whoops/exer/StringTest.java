package cnn.whoops.exer;

import com.sun.corba.se.impl.legacy.connection.EndPointInfoImpl;
import org.junit.Test;

/**
 * @author: whoops
 * @date: 2021/7/27 - 15:28
 * @description: 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 * 方式一：转换为char[]
 * 方式二：使用String拼接
 * 方式三：使用StringBuffer/StringBuilder
 */
public class StringTest {

    /**
     * @param str        需要进行反转的字符串
     * @param startIndex 从startIndex位置开始进行取值
     * @param endIndex   到endIndex位置结束取值
     * @return
     */
    public String reverse(String str, int startIndex, int endIndex) {

        if (str != null && str.length() != 0) {
            char[] arr = str.toCharArray();
            for (int i = startIndex, j = endIndex; i < j; i++, j--) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    @Test
    public void testReverse() {
        String str = "abcdefg";
        String reverse = reverse(str, 2, 5);
        System.out.println(reverse);
    }

    /**
     * @param str        需要进行反转的字符串
     * @param startIndex 从startIndex位置开始进行取值
     * @param endIndex   到endIndex位置结束取值
     * @return
     */
    public String reverse1(String str, int startIndex, int endIndex) {
        if (str != null && str.length() != 0){
            String first = str.substring(0, startIndex);
            for (int i = endIndex; i >= startIndex; i--) {
                first += str.charAt(i);
            }
            first += str.substring(endIndex + 1);
            return first;
        }
        return null;
    }

    @Test
    public void testReverse1(){
        String str = "abcdefghij";
        String reverse1 = reverse1(str, 2, 5);
        System.out.println(reverse1);
    }

    /**
     * @param str        需要进行反转的字符串
     * @param startIndex 从startIndex位置开始进行取值
     * @param endIndex   到endIndex位置结束取值
     * @return
     */
    public String reverse2(String str, int startIndex, int endIndex) {
        if (str != null && str.length() != 0){
            StringBuilder builder = new StringBuilder(str.length());
            for (int i = 0,j = startIndex; i < j; i++,j--) {
                builder.append(str.substring(i,j));              //把取出的值追加到builder中
            }

            for (int i = endIndex; i >= startIndex; i--) {
                builder.append(str.charAt(i));
//                System.out.println(builder);
            }

            builder.append(str.substring(endIndex + 1));
//            System.out.println(builder);

//            return builder.toString();  //使用toString()方法转换为String
            return new String(builder); //使用String构造器
        }
        return null;
    }

    @Test
    public void testReverse2(){
        String str = "abcdefghij";
        String s = reverse2(str, 2, 5);
        System.out.println(s);
    }

}
