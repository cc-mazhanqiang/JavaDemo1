package pon.test.demo.test12;

/**
 *  4. 对象数组题目：
 * 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。
 *  创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
 * 问题一：打印出3年级(state值为3）的学生信息。
 * 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
 *
 * 提示：
 * 1) 生成随机数：Math.random()，返回值类型double;
 * 2) 四舍五入取整：Math.round(double d)，返回值类型long。
 *
 */
public class Exer02 {

    public static void main(String[] args) {

        Student[] stu = new Student[20]; //创建20个数组对象

        for(int i = 0;i < stu.length;i++) {
            // 给数组创建对象赋值
            stu[i] = new Student();

            // 给数组对象的属性赋值
            stu[i].number = (i + 1);
            // 年级为[1,6]
            stu[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
            // 成绩为[0,100]
            stu[i].score = (int) (Math.random() * (100 - 0 + 1));
        }

            //  遍历数组
        for (int i = 0;i < stu.length;i++){
            System.out.println(stu[i].showInfo());
        }

        System.out.println("**********************************");

        // 问题一：打印出3年级(state值为3）的学生信息。

        for (int i = 0;i < stu.length;i++){
            if (stu[i].state == 3){
                System.out.println(stu[i].showInfo());
            }
        }

        System.out.println("**********************************");

        //  问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
        for (int i = 0;i < stu.length - 1;i++){
            for (int j = 0; j < stu.length - 1 -i;j++){
                if(stu[j].score > stu[j + 1].score){
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }

        //  遍历数组
        for (int i = 0;i < stu.length;i++){
            System.out.println(stu[i].showInfo());
        }




    }

}
class Student{
    int number; //学号
    int state;  //年级
    int score;  //成绩

    /* 定义一个显示学生信息的方法 */
    public String showInfo(){
        return "学号为：" + number + "\t" + "年级为：" + state + "\t" + "成绩为：" + score;
    }

}
