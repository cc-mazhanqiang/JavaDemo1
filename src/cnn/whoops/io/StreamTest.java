package cnn.whoops.io;

import org.junit.Test;

import java.io.*;

/**
 * @author: whoops
 * @date: 2021/8/1 - 14:06
 * @description: 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
 * 进行输入操作，直至当输入“e”或者“exit”时，退出程序
 */
public class StreamTest {

    public static void main(String[] args) {

        BufferedReader reader = null;
        try {
            //1、创建转换流
            InputStreamReader isr = new InputStreamReader(System.in);
            //创建缓冲流
            reader = new BufferedReader(isr);

            //读取数据
            while (true) {
                System.out.println("请输入字符串：");
                String line = reader.readLine();
                if ("e".equalsIgnoreCase(line) || "exit".equalsIgnoreCase(line)) {
                    System.out.println("程序结束");
                    break;
                }

                String upperCase = line.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 打印流：PrintStream 和 PrintWriter
     * 打印ASCII字符
     */
    @Test
    public void test(){
        PrintStream stream = null;
        try {
            //创建文件输出流，操作字节
            FileOutputStream fos = new FileOutputStream("M:\\test\\test.txt");

            //创建打印流
            stream = new PrintStream(fos,true);

            //把标准输出流改成文件
            if (stream != null){
                System.setOut(stream);
            }

            //打印ASCII字符
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0){
                    System.out.println();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (stream != null)
                try {
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }


    }


    /**
     * 数据流：DataInputStream 和 DataOutputStream
     * 作用：用于读取或写出基本数据类型的变量或字符串
     */
    @Test
    public void test1(){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));
            dos.writeUTF("张三");
            dos.flush();
            dos.writeInt(25);
            dos.flush();
            dos.writeChars("男");
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null)
                    dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("data.txt"));
            String name = dis.readUTF();
            int age = dis.readInt();
            char sex = dis.readChar();
            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("sex = " + sex);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null)
                    dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
