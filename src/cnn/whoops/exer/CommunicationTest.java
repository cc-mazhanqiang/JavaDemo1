package cnn.whoops.exer;

/**
 * @author: whoops
 * @date: 2021/7/24 - 21:58
 * @description: 线程通信的例子：
 * 使用两个线程打印 1-100。线程1, 线程2 交替打印
 */

class PrintNum implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while (true){

            //同步代码块,解决线程安全问题，this表示当前的对象，一定要唯一。
            synchronized (this){

                notify();//唤醒单个阻塞的线程
//                notifyAll();//唤醒全部阻塞的线程

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (number <= 100){
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    //实现交替打印，当一个线程执行之后，让它进入阻塞状态。
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        Thread thread1 = new Thread(printNum);
        Thread thread2 = new Thread(printNum);

        thread1.setName("线程1");
        thread2.setName("线程2");

        thread1.start();
        thread2.start();
    }
}
