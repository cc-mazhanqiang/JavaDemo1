package cnn.whoops.exer;

/**
 * @className:
 * @author: whoops
 * @description: TODO
 * @date: 2021/7/24 - 15:37
 */

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 */
class Window2 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":" + "卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {

        Window2 window2 = new Window2();

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
