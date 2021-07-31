package cnn.whoops.thread;

/**
 * @className:
 * @author: whoops
 * @description: TODO
 * @date: 2021/7/24 - 16:00
 */

/**
 * 使用同步机制解决之前所说的单例模式中的懒汉式模式的线程安全问题
 */
public class BankTest {
}

class Bank{
    private Bank(){}

    private static Bank instance = null;

    public static synchronized Bank getInstance() {

        if (instance == null){
            instance = new Bank();
        }
        return instance;


        //  同步代码块
//        if (instance == null){
//
//            synchronized (Bank.class) {
//                if (instance == null){
//                    instance = new Bank();
//                }
//            }
//        }
//        return instance;

    }

}