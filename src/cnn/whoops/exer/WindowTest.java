package cnn.whoops.exer;

/**
 * @className:
 * @author: whoops
 * @description: TODO
 * @date: 2021/7/23 - 20:21
 */

/**
 * 例子：创建三个窗口卖票，总票数为100张。实现Thread类的方式
 *
 */

class Window extends Thread{

    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (obj){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0){
                    System.out.println(getName() + ":" + "卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}


public class WindowTest {
    public static void main(String[] args) {
        Window window = new Window();
        Window window1 = new Window();
        Window window2 = new Window();

        window.setName("窗口1");
        window1.setName("窗口2");
        window2.setName("窗口3");

        window.start();
        window1.start();
        window2.start();
    }
}
