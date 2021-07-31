package cnn.whoops.thread;

/**
 * @className:
 * @author: whoops
 * @description: TODO
 * @date: 2021/7/24 - 16:39
 */


import java.util.concurrent.locks.ReentrantLock;

/**
 *  解决线程的安全问题：Lock锁
 */

class Window implements Runnable{

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                //调用锁定的方法：lock()
                lock.lock();

                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + "卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //调用解锁的方法：unlock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window window2 = new Window();

        Thread thread1 = new Thread(window2);
        Thread thread2 = new Thread(window2);
        Thread thread3 = new Thread(window2);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
