package cnn.whoops.exer;

/**
 * @className:
 * @author: whoops
 * @description: TODO
 * @date: 2021/7/22 - 22:15
 */

/*
    练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0){
                System.out.println(i);
            }
        }
    }
}