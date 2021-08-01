package cnn.whoops.io;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: whoops
 * @date: 2021/8/1 - 21:02
 * @description:
 *
 * RandomAccessFile的使用
 * 1、RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2、RandomAccessFile既可以作为一个输入流，也可以作为一个输出流
 *
 * 3、如果RandomAccessFile作为输出流时，写出的文件如果不存在，则在执行的过程中自动创建
 *      如果写出的文件存在，则会对原有文件的内容进行覆盖（默认情况下，从头开始覆盖）
 */
public class RandomAccessFileTest {
    @Test
    public void test(){
        RandomAccessFile raf1 = null;//以只读的方式，输入
        RandomAccessFile raf2 = null;//以读取和写入的方式，输出
        try {
            raf1 = new RandomAccessFile(new File("psc.jpg"), "r");
            raf2 = new RandomAccessFile(new File("psc4.jpg"), "rw");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = raf1.read(bytes)) != -1){
                raf2.write(bytes,0,len);
            }
            System.out.println("操作成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf2 != null)
                    raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1(){
        RandomAccessFile rw = null;//作为输出流
        File file = new File("hello3.txt");
        try {
            rw = new RandomAccessFile(file, "rw");
            rw.seek(3);//将指针调到角标为3的位置
            rw.seek(file.length());//将指针调到文件末尾的位置，则会实现追加的效果
            rw.write("zyx".getBytes());//会覆盖原有文件的内容
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rw != null)
                    rw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3(){
        RandomAccessFile rw = null;//作为输出流
        File file = new File("hello3.txt");
        try {
            rw = new RandomAccessFile(file, "rw");
            rw.seek(3);//将指针调到角标为3的位置
            //将指针 3 后面的数据添加到StringBuffer中
            StringBuilder sbu = new StringBuilder((int) file.length());
            byte[] bytes = new byte[1024];
            int len;
            while ((len = rw.read(bytes)) != -1){
                sbu.append(new String(bytes,0,len));
            }

            //调回指针的位置，写入"xyz"
            rw.seek(3);
            rw.write("xyz".getBytes());

            //将StringBuilder中的数据写入到文件中
            rw.write(sbu.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rw != null)
                    rw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4(){
        RandomAccessFile raf = null;
        ByteArrayOutputStream baos = null;
        try {
            raf = new RandomAccessFile(new File("hello3.txt"),"rw");
            //指定指针位置
            raf.seek(5);
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = raf.read(bytes)) != -1){
                baos.write(bytes,0,len);
            }

            //调回指针的位置，写入数据
            raf.seek(5);
            raf.write("whoops".getBytes());

            raf.write(baos.toString().getBytes());
            System.out.println("操作成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
