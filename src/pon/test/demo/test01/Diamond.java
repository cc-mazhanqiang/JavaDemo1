package pon.test.demo.test01;

public class Diamond {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {    //打印行数
            for(int j = 1; j <= 3-i; j++){  //打印空格
                System.out.print(" ");
            }
            for(int k = 1;k <= 2*i-1; k++){ //打印“*”
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 1;i <= 2;i++){  //打印行数
            for(int j = 1;j <= i;j++){  //打印空格
                System.out.print(" ");
            }
            for(int k = 1;k <= 5-2*i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
