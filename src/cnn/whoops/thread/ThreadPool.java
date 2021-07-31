package cnn.whoops.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: whoops
 * @date: 2021/7/26 - 10:43
 * @description: 使用线程池创建线程
 */

class PrintNum implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        service1.setCorePoolSize(15);

//        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

//        service.setCorePoolSize(15);

        service.execute(new PrintNum());  // 使用于Runnable接口
//        service.submit();   // 使用于Callable接口

        // 关闭连接池
        service.shutdown();
    }

}
