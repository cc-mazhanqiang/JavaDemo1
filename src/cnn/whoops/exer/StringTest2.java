package cnn.whoops.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: whoops
 * @date: 2021/7/27 - 17:04
 * @description:
 * 获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 */
public class StringTest2 {

    public String[] getMaxSameSubString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();

            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {     //假设短的字符串是和长的字符串是相同的
                for (int x = 0, y = len - i; y <= len; x++, y++) {   //x表示从头开始，y表示从末尾开始,头尾各去掉一个字符
                    String subString = minString.substring(x, y);   //截取从 x 到 y 结束的子字符串
                    if (maxString.contains(subString)) {         //判断是否在maxString字符串当中，如果是则追加到sBuffer中
                        sBuffer.append(subString + ",");
                    }
                }
                if (sBuffer.length() != 0) {        //判断sBuffer中是否有值，有的话则结束循环
                    break;
                }
            }
            // 正则表达式， 表示把最后一个逗号，替换为空  以逗号进行切割
            String[] sameString = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return sameString;
        }
        return null;
    }

    @Test
    public void testMaxSameString() {
        String str1 = "abcwerthello1234yuioabcdef456";
        String str2 = "cvhello1234bnmabcdef456";
        String[] maxSameSubString = getMaxSameSubString(str1, str2);
        System.out.println(Arrays.toString(maxSameSubString));

    }

}
