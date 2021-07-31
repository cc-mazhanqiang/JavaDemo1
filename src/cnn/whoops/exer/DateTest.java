package cnn.whoops.exer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author: whoops
 * @date: 2021/7/27 - 22:11
 * @description: 字符串"2021-08-10"转换为java.sql.Date
 */
public class DateTest {

    @Test
    public void testDate() throws ParseException {
        String birth = "2021-08-10";
        Date date3 = new Date();
        System.out.println(date3);

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

        String format = date.format(date3);
        System.out.println(format);

        Date date1 = date.parse(birth);
        System.out.println(date1);

        //转换为java.sql.Date
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }

    //  对"三天打鱼两天晒网的求解"
    @Test
    public void testDate1() throws ParseException {
        String date1 = "2021-08-10";
        String date2 = "1990-01-01";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //解析date1、date2
        Date parse1 = dateFormat.parse(date1);
//        System.out.println(parse1);
//        System.out.println(parse1.getTime());
        Date parse2 = dateFormat.parse(date2);

        if (parse1.getTime() > parse2.getTime()) {
            long day = parse1.getTime() - parse2.getTime();
            long days = day / (1000 * 60 * 60 * 24) + 1;
            System.out.println(days);
            if (days % 5 == 1 || days % 5 == 2 || days % 5 == 3) {
                System.out.println("打鱼");
            } else if (days % 5 == 4 || days % 5 == 0) {
                System.out.println("晒网");
            }
        } else if (parse1.getTime() < parse2.getTime()) {
            long day = parse2.getTime() - parse1.getTime();
            long days = day / (1000 * 60 * 60 * 24) + 1;    //如果有效数，则天数加 1
            if (days % 5 == 1 || days % 5 == 2 || days % 5 == 3) {
                System.out.println("打鱼");
            } else if (days % 5 == 4 || days % 5 == 0) {
                System.out.println("晒网");
            }
        } else {
            System.out.println("两数相等！");
        }

    }

    @Test
    public void testCalendar() {

        //  Calendar是抽象的类，不能直接被实例化，需要调用它的子类或使用getInstance()方法创建对象
        Calendar calendar = Calendar.getInstance(); //创建Calendar的对象
        GregorianCalendar calendar1 = new GregorianCalendar();  //使用子类创建Calendar的对象

        //常用的方法
        //get()
        int day = calendar.get(Calendar.DAY_OF_MONTH);//表示这个月的第几天
        System.out.println(day);

        int day1 = calendar.get(Calendar.DAY_OF_WEEK);//表示这个星期的第几天
        System.out.println(day1);

        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 31);    //把当前月的当前天设置为第 31 天
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,4);//表示在当前月的当前天的基础上加 4 天
//        calendar.add(Calendar.DAY_OF_MONTH,-4);//表示在当前月的当前天的基础上减 4 天
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        //getTime() 日历类 ---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime() Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

    }

}
