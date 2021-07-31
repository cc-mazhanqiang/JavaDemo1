package cnn.whoops.io;

import org.junit.Test;
import org.junit.internal.runners.statements.FailOnTimeout;

import java.io.*;

/**
 * @author: whoops
 * @date: 2021/7/31 - 14:44
 * @description:
 */
public class FileReaderTest {

    //从硬盘文件中读取数据到内存中
    @Test
    public void test() {
        FileReader fr = null;
        try {
            //1、实例化File类的对象，指明要操作的文件
            File file = new File("D:\\IdeaJava\\JavaDemo01\\hello.txt");
            //2、提供具体的流
            fr = new FileReader(file);
            //3、数据的读入
            //read():返回读入的一个字符，如果达到文件末尾，返回-1.
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            File file = new File("D:\\IdeaJava\\JavaDemo01\\hello.txt");

            fileReader = new FileReader(file);

            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                //错误的写法
                //            for (int i = 0; i < cbuf.length; i++) {
                //                System.out.print(cbuf[i]);//HelloWorld123ld
                //            }

                //            for (int i = 0; i < len; i++) {
                //                System.out.print(cbuf[i]);//HelloWorld123
                //            }

                //错误的写法
                //            String str = new String(cbuf);
                //            System.out.print(str);//HelloWorld123ld

                String str = new String(cbuf, 0, len);
                System.out.print(str);//HelloWorld123

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //从内存中写出数据到硬盘的文件中
    @Test
    public void test2() {
        FileWriter fw = null;
        try {
            //1、提供File类的对象，指明要写到的文件
            File file = new File("D:\\IdeaJava\\JavaDemo01\\hello1.txt");
            //2、提供FileWriter的对象，用于数据的写出
            /**
             * 说明：如果本地硬盘中不存在此文件，则会自动创建此文件
             * 如果本地磁盘存在此文件，使用的构造器为new FileWriter(file,false),则会覆盖原有的文件。
             *                        使用的构造器为new FileWriter(file,true),则不会覆盖原有的文件，追加写入内容。
             */
            fw = new FileWriter(file);
            //3、写出的操作
            fw.write("I hava a dream!\n");
            fw.write("you need to hava a dream!\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                //4、关闭流的操作
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test3() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1、创建File类的对象，指明读入和写出的文件
            File file = new File("hello.txt");
            File file1 = new File("hello2.txt");

            //2、创建输入流和输出流的对象
            fr = new FileReader(file);
            fw = new FileWriter(file1);
            //3、数据的读入和写出
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写入len个字符
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对字节流的读取和写出操作
    @Test
    public void test4() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1、创建File类的对象，指明读取和写出的文件
            File file = new File("psc.jpg");
            File file1 = new File("psc1.jpg");

            //2、创建字节流的输入和输出的对象
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            //3、数据的操作
            byte[] cbuf = new byte[5];
            int len;
            while ((len = fis.read(cbuf)) != -1) {
                fos.write(cbuf,0,len);
            }
            System.out.println("操作成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流的关闭
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void copyFile(String srcPath,String desPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1、创建File类的对象，指明读取和写出的文件
            File file = new File(srcPath);
            File file1 = new File(desPath);

            //2、创建字节流的输入和输出的对象
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);


            //3、对数据读写的操作
            byte[] cbuf = new byte[1024];
            int len;
            while ((len = fis.read(cbuf)) != -1) {
                fos.write(cbuf,0,len);
            }
            System.out.println("操作成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流的关闭
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test5(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\asus\\Desktop\\01.mp4";
        String desPath = "C:\\Users\\asus\\Desktop\\02.mp4";
        copyFile(srcPath,desPath);
        long end = System.currentTimeMillis();
        System.out.println("所执行的时间为：" + (end - start));//127
    }

}
