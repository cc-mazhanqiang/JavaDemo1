package pon.test.demo.test04;

public class PrimeNumber2 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int count = 0;

        label:for(int i = 2;i <= 100;i++){

            // 从2开始看是否能被 i-1 的数整除，如果能则不是质数，否则是。
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                   continue label;
                }
            }
                count++;
                System.out.print(i + ",");
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("质数的个数为：" +count);
        System.out.println("所花费的时间为：" +(end - start));
    }
}
