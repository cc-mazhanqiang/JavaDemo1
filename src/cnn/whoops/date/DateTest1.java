package cnn.whoops.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author: whoops
 * @date: 2021/7/27 - 23:28
 * @description:
 *
 * 本地日期（LocalDate）、本地时间 LocalTime）、本地日期时间（LocalDateTime）
 */
public class DateTest1 {

    @Test
    public void testDateJDK8API(){
        // 获取当前本地时间 now()
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of():设置指定的年、月、日、时、分、秒 是没有偏移量的
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 7, 27, 13, 13, 13);
        System.out.println(localDateTime1);

        //getXxx():获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonthValue());

        // 体现了不可变性
        // withXxx():设置相关的时间属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(29);
        System.out.println(localDateTime);  //2021-07-28T09:14:22.002
        System.out.println(localDateTime2); //2021-07-29T09:14:22.002

        //plusXxx():加相应的时间
        LocalDateTime localDateTime3 = localDateTime.plusMonths(2);
        System.out.println(localDateTime);//2021-07-28T09:17:54.969
        System.out.println(localDateTime3);//2021-09-28T09:17:54.969

        //minusXxx():减相应的时间
        LocalDateTime localDateTime4 = localDateTime.minusMonths(2);
        System.out.println(localDateTime);//2021-07-28T09:19:48.328
        System.out.println(localDateTime4);//2021-05-28T09:19:48.328

        // Instant的使用
        //获取本初子午线的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2021-07-28T01:30:15.449Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2021-07-28T09:32:04.533+08:00

        //获取示自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli); //1627435978533

        //通过给定的毫秒数获取Instant实例，存在偏移量
        Instant instant1 = Instant.ofEpochMilli(1627435978533L);
        System.out.println(instant1);//2021-07-28T01:32:58.533Z


        //DateTimeFormatter的使用
        //自定义格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        //格式化
        String str = formatter.format(LocalDateTime.now());
        System.out.println(str);//2021-07-28 10:43:49

        //解析
        TemporalAccessor accessor = formatter.parse("2021-07-28 10:43:49");
        System.out.println(accessor);
    }
}
