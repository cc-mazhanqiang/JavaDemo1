package cnn.whoops.exer;

/**
 * @author: whoops
 * @date: 2021/7/24 - 22:44
 * @description: 线程通信的应用：经典例题：生产者/消费者问题。
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 */

class Clerk{

    private int productCount = 0;

    //生产产品
    public synchronized void produceProduct() {
        if (productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第"+ productCount +"个产品。");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void cosumeProduct() {
        if (productCount > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第"+ productCount +"个产品。");
            productCount--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor extends Thread{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":" + "开始生产产品...");
        while (true){

            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}

class Customers extends Thread{
    private Clerk clerk;

    public Customers(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":" + "开始消费产品...");
        while (true){

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.cosumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk);
        productor.setName("生产者");

        Customers customers = new Customers(clerk);
        customers.setName("消费者");

        productor.start();
        customers.start();
    }
}
