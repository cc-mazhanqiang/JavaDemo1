package pon.test.demo.test04;

public class PrimeNumber {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 0;
        for(int i = 2;i <= 100;i++){
            boolean isFlag = true;
            // Math.sqrt(i)意思是取 2~Math.sqrt(i)之间的质数
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if (isFlag == true){
                count++;
                System.out.print(i + ",");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("质数的个数为：" +count);
        System.out.println("所花费的时间为：" +(end - start));
    }
}
