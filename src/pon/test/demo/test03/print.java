package pon.test.demo.test03;

public class print {
    public static void main(String[] args) {
        print(10);
    }
    public static void print(int num){
        for (int i = 1; i <= num; i++) {
            System.out.println("Hello,World!" +i);
        }
    }
}
