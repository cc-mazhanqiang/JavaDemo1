package cnn.whoops.enums;

/**
 * @author: whoops
 * @date: 2021/7/28 - 14:47
 * @description:
 * 自定义枚举类：
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}

class Season{

    private final String seasonName;
    private final String seasonDec;

    private Season(String seasonName,String seasonDec){
        this.seasonName = seasonName;
        this.seasonDec = seasonDec;
    }

    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","天寒地冻");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDec() {
        return seasonDec;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDec='" + seasonDec + '\'' +
                '}';
    }
}