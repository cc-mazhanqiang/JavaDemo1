package cnn.whoops.exer;

/**
 * @className:
 * @author: whoops
 * @description: TODO
 * @date: 2021/7/23 - 21:13
 */

/**
 * 例子：创建三个窗口卖票，总票数为100张。实现Runnable接口的方式
 *
 * 问题：1.卖票的过程中出现了 重票、错票    -------> 线程的安全问题
 *
 * 产生问题的原因：当某个线程操作车票的过程中，在没有完成的情况下，又有其他线程也参与进来。
 *
 * 如何解决：当一个线程正在操作共享数据的时候，其他线程不能参与出来，直到当前线程操作完成之后，其他线程才可以开始操作。
 *          这种情况即使出现了阻塞，也不能被改变。
 *
 * 在java开发过程中：通过同步机制，来解决线程的安全问题。
 *
 * 方式一：同步代码块
 *      synchronized(同步监视器){
 *          //需要被同步的代码  说明：操作共享数据的代码，即为需要被同步的代码。
 *          //同步监视器，俗称：锁；任何一个类的对象都可以充当锁。
 *              要求：多个线程必须要公用同一把锁。
 *      }
 *
 *
 * 方式二：同步方法
 * 如果操作共享数据的代码完整的声明在一个方法中，我们可以把这个方法声明为同步的。
 *
 */

class Window1 implements Runnable{

    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (obj){
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
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {

        Window1 window1 = new Window1();

        Thread thread1 = new Thread(window1);
        Thread thread2 = new Thread(window1);
        Thread thread3 = new Thread(window1);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
