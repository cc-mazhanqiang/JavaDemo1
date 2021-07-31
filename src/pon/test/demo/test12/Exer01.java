package pon.test.demo.test12;

/**
 *  声明一个method方法，在方法中打印一个m*n的*矩形，并返回面积值。
 */

public class Exer01 {
    public static void main(String[] args) {
        Exer01 ee = new Exer01();
        double area = ee.method(10,8);
        System.out.println("面积为：" +area);
    }

    public int method(int m,int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        return m * n;
    }
}
