/*
一个数如果恰好等于它的因子之和，这个数就称为“完数”，例如：6 = 1 + 2 + 3。
找出1000以内的所有完数。（因子：除去这个数本身的所有其它约数）
 */
package pon.test.demo.test05;

public class WanShuTest {
    public static void main(String[] args) {

        for(int i = 1;i <= 1000; i++){
            int factor = 0; //记录因子之和。
            for(int j = 1;j < i; j++){ //找这个数的因子。
                if(i % j == 0){
                    factor += j;
                }
            }
            // 如果这个数等于它自己的因子之和，就输出这个数。
            if(i == factor){
                System.out.print(i + ",");
            }
        }
    }
}
