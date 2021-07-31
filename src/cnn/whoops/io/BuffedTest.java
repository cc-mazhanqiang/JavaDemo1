package cnn.whoops.io;

import org.junit.Test;

import java.io.*;

/**
 * @author: whoops
 * @date: 2021/7/31 - 21:15
 * @description:
 * 缓冲流的使用
 */
public class BuffedTest {
    @Test
    public void BuffedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1、创建文件
            File file = new File("psc.jpg");
            File file1 = new File("psc2.jpg");

            //2、创建节点流（文件流）
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);

            //2.1、创建缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3、数据的读写操作
            byte[] buff = new byte[10];
            int len;
            while ((len = bis.read(buff)) != -1){
                bos.write(buff,0,len);
            }

            System.out.println("操作成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            //只需要关闭最外层的流
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //1、创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //2、读写操作
            //方式一：
//            char[] buff = new char[1024];
//            int len;
//            while ((len = br.read(buff)) != -1){
//                bw.write(buff,0,len);
//            }
            //方式二：
            String data;
            while ((data = br.readLine()) != null){
                bw.write(data);
                bw.newLine();
            }

            System.out.println("操作成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3、关闭流
            try {
                if (br != null)
                    br.close();
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
