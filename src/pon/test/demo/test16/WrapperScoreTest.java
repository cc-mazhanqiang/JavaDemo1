package pon.test.demo.test16;

import java.util.Scanner;
import java.util.Vector;

/**
 * @className: pon.test.demo.test16.WrapperScoreTest
 * @author: sir
 * @description: TODO
 * @date: 2021/5/21 - 22:13
 */

/*
    利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
	提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。
	而向量类java.util.Vector可以根据需要动态伸缩。

	创建Vector对象：Vector v=new Vector();
	给向量添加元素：v.addElement(Object obj);   //obj必须是对象
	取出向量中的元素：Object  obj=v.elementAt(0);
	注意第一个元素的下标是0，返回值是Object类型的。
	计算向量的长度：v.size();
	若与最高分相差10分内：A等；20分内：B等；
	      30分内：C等；其它：D等
 */

public class WrapperScoreTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Vector v = new Vector();//创建Vetor对象代替数组
        int maxScore = 0;
        for (;;){
            System.out.println("请输入学生的成绩（以负数代表输入结束）：");
            int score = scan.nextInt();//从键盘读取学生的成绩
            if (score < 0){
                break;
            }
            if (score > 100){
                System.out.println("输入的数据非法，请重新输入！");
                continue;
            }

//            JDK1.5之前
//            Integer inScore = new Integer(score);//把int转换成包装类
//            v.addElement(inScore);//多态
//            JDK1.5之后
            v.addElement(score);//把学生成绩添加到对象数组中
            if (maxScore < score){
                maxScore = score;
            }

        }

        char level;
        for (int i = 0;i < v.size(); i++){
            Object obj = v.elementAt(i);//获取学生的成绩
//            JDK1.5之前
//            Integer inScore = (Integer) obj;//把obj对象转换成Integer类
//            int intValue = inScore.intValue();//把Integer类转换成int型

//            JDK1.5之后
            int score = (int) obj;
            if (maxScore - score <= 10){
                level = 'A';
            }else if(maxScore - score <= 20){
                level = 'B';
            }else if (maxScore - score <= 30){
                level = 'C';
            }else {
                level = 'D';
            }

            System.out.println("student-" + (i + 1) + " score is " + score + ",level is " + level);
        }

    }

}
