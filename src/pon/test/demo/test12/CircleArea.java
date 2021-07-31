package pon.test.demo.test12;

/**
 * 使用面向对象的方法，计算三角形的面积
 */
public class CircleArea {

    public static void main(String[] args) {

        Circle cl = new Circle();

        cl.radius = 3.5;

        System.out.println(cl.Area());

    }
}

class Circle {
    double radius;

    public double Area(){

        double area = Math.PI * radius * radius;
        return area;

    }
}