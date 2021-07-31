package cnn.whoops.file;

import org.junit.Test;

import java.io.File;

/**
 * @author: whoops
 * @date: 2021/7/31 - 9:24
 * @description: 遍历指定目录所有文件名称，包括子文件目录中的文件。
 * * 	拓展1：并计算指定目录占用空间的大小
 * * 	拓展2：删除指定文件目录及其下的所有文件
 */
public class FileTest {

    public static void main(String[] args) {
        File file = new File("M:\\Java从入门到精通(第四版)");
//        printFiles(file);
        FileTest ft = new FileTest();
//        ft.printFiles2(file);
        long size = ft.getSize(file);
        System.out.println(size);

        File file1 = new File("M:\\IEDA破解版\\tool\\IDEA破解版\\idea");
        ft.delFile(file1);
    }

    //递归
    public static void printFiles(File dir) {
        File[] files = dir.listFiles();     //遍历某一目录下所有的文件
        for (File file : files) {
            if (file.isDirectory()) {       //判断是否是目录
                printFiles(file);           //是目录的话进行递归操作
            } else {
                System.out.println(file.getAbsolutePath()); //不是目录的话输出文件的绝对路径
            }
        }
    }

    //循环实现
    //只打印出以及目录的文件
    public void printFiles2(File file){
        if (file.isDirectory()){

            String[] list = file.list();
            for (String s : list) {
                System.out.println(s);
            }

        }else{
            System.out.println(file + "是文件");
        }
    }

    //计算指定目录占用空间的大小
    public long getSize(File file){
        long size = 0;

        if (file.isFile()){
            size += file.length();
        }else{
            File[] files = file.listFiles();
            for (File file1 : files) {
                size += getSize(file1);
            }
        }
        return size;
    }

    //删除指定文件目录及其下的所有文件
    public void delFile(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                delFile(file1);
            }
        }
        file.delete();//如果是文件的话直接删除
    }

    //判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
    @Test
    public void test(){
        File file = new File("D:\\");
        String[] list = file.list();
        for (String s : list) {
            if (s.endsWith(".jpg")){
                System.out.println(s);
            }
        }
    }

}
