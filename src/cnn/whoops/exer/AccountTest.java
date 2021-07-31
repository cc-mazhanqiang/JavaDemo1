package cnn.whoops.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @className:
 * @author: whoops
 * @date: 2021/7/24 - 21:32
 * @description: 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 */

class Account{
    private double balance;

    //对象要唯一，操作的数据也要唯一。
    private ReentrantLock lock = new ReentrantLock();

    //synchronized 同步机制 this 表示当前对象，但一定要唯一。
    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amt){

        try {
            lock.lock();
            if (amt > 0){
                balance += amt;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为：" + balance);
            }
        }finally {
            lock.unlock();
        }

    }
}

class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        customer1.setName("甲");
        customer2.setName("乙");

        customer1.start();
        customer2.start();
    }
}
