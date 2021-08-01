package cnn.whoops.io;

import org.junit.Test;

import java.io.*;


/**
 * @author: whoops
 * @date: 2021/8/1 - 9:39
 * @description:
 *
 * 处理流：转换流的使用
 * 1、字符流 ---> 作用：提供字节流与字符流之间的转换
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 * 解码：字节、字节数组 ---> 字符串、字符数组
 * 编码：字符串、字符数组 ---> 字节、字节数组
 *
 * 字符集：
 * ASCII：美国标准信息交换码。用一个字节的7位可以表示。
 * ISO8859-1：拉丁码表。欧洲码表用一个字节的8位表示。
 * GB2312：中国的中文编码表。最多两个字节编码所有字符
 * GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 * Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 * UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 *
 */
public class InputStreamReaderTest {

    @Test
    public void test() {
        InputStreamReader isr = null;
        try {
            //1、创建字节输入流的文件
            FileInputStream fis = new FileInputStream("dbcp.txt");

            //2、创建字符输入流
            //第二个参数指明字符集，具体使用哪个取决于保存文件所用的字符集
            isr = new InputStreamReader(fis,"UTF-8");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //综合使用转换流
    @Test
    public void test1(){

        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file = new File("dbcp.txt");
            File file1 = new File("dbcp_gbk.txt");

            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);

            isr = new InputStreamReader(fis,"utf-8"); //解码
            osw = new OutputStreamWriter(fos, "gbk");  //编码

            char[] cubf = new char[20];
            int len;
            while ((len = isr.read(cubf)) != -1){
                osw.write(cubf,0,len);
            }

            System.out.println("操作成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osw != null)
                    osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
