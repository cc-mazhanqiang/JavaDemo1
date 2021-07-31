package abb.pattern.test;

/**
 * @className: abb.pattern.test.TemplateTest
 * @author: sir
 * @description: TODO
 * @date: 2021/5/25 - 21:54
 */
public class TemplateTest {
    public static void main(String[] args) {
        Template subTemplate = new SubTemplate();
        subTemplate.spendTime();
    }
}

//模板方法设计模式
abstract class Template{

    public abstract void code();

    public final void spendTime(){

        long start = System.currentTimeMillis();//计算时间
        code();//不确定的、易变的部分
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("所花费的时间为：" + (end - start));
    }
}

class SubTemplate extends Template{

    //计算100以内的质数
    @Override
    public void code() {
        for (int i = 2; i < 100; i++) {
            boolean isFlag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if (isFlag){
                System.out.print(i + "、");
            }
        }
    }
}