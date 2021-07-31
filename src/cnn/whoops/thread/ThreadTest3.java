package cnn.whoops.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: whoops
 * @date: 2021/7/24 - 23:18
 * @description: 线程的创建方式三：实现Callable()接口。
 */

class MyThread2 implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadTest3 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();

        FutureTask futureTask = new FutureTask(myThread2);
        new Thread(futureTask).start();

        try {
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
