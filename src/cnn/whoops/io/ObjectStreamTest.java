package cnn.whoops.io;

import org.junit.Test;

import java.io.*;

/**
 * @author: whoops
 * @date: 2021/8/1 - 15:47
 * @description:
 *
 * 对象流的使用：
 * ObjectInputStream 和 ObjectOutputStream
 * 作用：用于存储和读取基本数据类型或对象的处理流
 *
 * 实现序列化的要求：
 * ①需要当前对象实现接口：Serializable
 * ②当前类需要提供一个全局常量：serialVersionUID
 * ③其内部属性也必须是可序列化的
 *
 */
public class ObjectStreamTest {
    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     */

    @Test
    public void test(){
        ObjectOutputStream oos = null;
        try {
            //创建对象输出流
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));

            oos.writeObject(new String("我爱中国！"));
            oos.flush();

            oos.writeObject(new Person("张三",25));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 反序列化过程：将磁盘文件中的对象还原为内存中的java对象
     */
    @Test
    public void test1(){
        ObjectInputStream ois = null;
        try {
            //创建对象输入流
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            Object object = ois.readObject();
            String str = (String) object;
            System.out.println(str);

            Person person = (Person) ois.readObject();
            System.out.println(person);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
