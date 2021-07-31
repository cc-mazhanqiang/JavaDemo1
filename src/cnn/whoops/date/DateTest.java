package cnn.whoops.date;

import org.junit.Test;

import java.util.Date;

/**
 * @author: whoops
 * @date: 2021/7/27 - 14:32
 * @description:
 */
public class DateTest {

    @Test
    public void test(){
        Date date = new Date();
        System.out.println(date.toString());    //Tue Jul 27 14:34:17 CST 2021

        System.out.println(date.getTime());     //1627367657349 获取毫秒数

        Date date1 = new Date(1627367657349L);
        System.out.println(date1.toString());

        /**
         * java.util.Date转为java.sql.Date
         */

        Date date2 = new Date();    //java.util.Date
        System.out.println(date2);
        java.sql.Date date3 = new java.sql.Date(date2.getTime());
        System.out.println(date3);
    }

}
