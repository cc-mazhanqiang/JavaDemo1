package cnn.whoops.enums;

/**
 * @author: whoops
 * @date: 2021/7/28 - 14:54
 * @description:
 *
 * 一、使用enum关键字定义枚举类，继承的父类是java.lang.Enum
 *
 * 二、Enum类常用的方法：
 * values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的
 * 枚举值。
 * valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符
 * 串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 * toString()：返回当前枚举类对象常量的名称
 *
 * 三、使用enum关键字定义的枚举类实现接口的情况
 * ---> 可以让枚举类中的对象分别去实现接口中的抽象方法
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);//SPRING

        System.out.println(Season1.class.getSuperclass());//class java.lang.Enum

        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

    }
}

interface Info{
    public abstract void show();
}

enum Season1 implements Info{
    //注意：使用enum关键字定义枚举类时，一定要先声明对象，必须省略public static final 以及 类名。
    //多个对象之间使用逗号隔开
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋");
        }
    },
    WINTER("冬天","天寒地冻"){
        @Override
        public void show() {
            System.out.println("冬");
        }
    };

    private final String seasonName;
    private final String seasonDec;

    private Season1(String seasonName,String seasonDec){
        this.seasonName = seasonName;
        this.seasonDec = seasonDec;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDec() {
        return seasonDec;
    }

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDec='" + seasonDec + '\'' +
                '}';
    }
}