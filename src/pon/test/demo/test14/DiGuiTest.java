package pon.test.demo.test14;
/*
    递归方法
 */
public class DiGuiTest {
    public static void main(String[] args) {
        // 1-100之间的整数和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
        DiGuiTest test = new DiGuiTest();
        int sum1 = test.getSum(100);
        System.out.println(sum1);
        int sum2 = test.getSum1(5);
        System.out.println(sum2);

        System.out.println("*****************************");
        int f = test.getf(10);
        System.out.println(f);

        System.out.println("*****************************");

        // 遍历斐波那契数列 并求和
        int sum3 = 0;
        for (int i = 1;i <= 10;i++){
            System.out.print(Fibonacci(i) + " ");
            sum3 += Fibonacci(i);
        }
        System.out.println();
        System.out.println(sum3);
        /*int fibo = test.Fibonacci(5);
        System.out.println(fibo);*/
    }
        // 递归方法、求1-n之间整数的和
    public int getSum(int n){
        if (n == 1){
            return 1;
        }else{
            return n + getSum(n - 1);
        }
    }

        // 递归方法、求1-n之间的阶乘
    public int getSum1(int n){
        if (n == 1){
            return 1;
        }else{
            // 假设输入的n为3，则 3 * getSum1（3 - 1）；当 n 为 1 的时候返回 1，循环结束。
            return n * getSum1(n - 1);
        }
    }

        //  递归的例子
        // 已知有一个数列：f（0） = 1，f（1） = 4，f（n + 2） = 2 * f（n + 1） + f（n）
        // 求f（10）的值
    public int getf(int n){
        if(n == 0){
            return 1;
        }else if (n == 1){
            return 4;
        }else{
            return 2 * getf(n - 1) + getf(n - 2);
        }
    }

    //  斐波那契数列 “兔子数列”
    /*
        输入一个数据n，计算斐波那契数列(Fibonacci)的第n个值
        1 1 2 3 5 8 13 21 34 55
        规律：一个数等于前两个数之和
        要求：计算斐波那契数列(Fibonacci)的第n个值，并将整个数列打印出来
     */

    public static int Fibonacci(int n){
            if (n == 2 || n == 1 || n == 0) {
                return 1;
            } else {
                return Fibonacci(n - 1) + Fibonacci(n - 2);
            }
    }
}
