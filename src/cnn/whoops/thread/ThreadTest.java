package cnn.whoops.thread;

import java.util.concurrent.ForkJoinPool;

/**
 * @className:
 * @author: whoops
 * @description: TODO
 * @date: 2021/7/22 - 21:39
 */
//  使用多线程计算100以内的质数
class MyThread extends Thread{
    @Override
    public void run() {
        boolean flag = true;
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j < i; j++) {   // 除以这个数前面的数
                if (i % j == 0){    //如果能被整除的话，则这个数不是质数
                    flag = false;
                }
            }
            if (flag){
                System.out.println(i);
            }
            flag = true;
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start(); //start()作用：①启动当前线程   ②调佣当前线程的run()方法
    }
}
