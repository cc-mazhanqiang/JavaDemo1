package cnn.whoops.thread;

/**
 * @className:
 * @author: whoops
 * @description: TODO
 * @date: 2021/7/23 - 20:54
 */

/**
 * 创建线程的方式二：实现Runnable接口
 *
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法:run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Threa类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调佣start()
 */

class MyThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(myThread1);

        thread.start();
    }
}
