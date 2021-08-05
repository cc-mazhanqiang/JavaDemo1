package cnn.whoops.lambda.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author: whoops
 * @date: 2021/8/5 - 22:59
 * @description:
 */
public class OptionalTest {

    //创建Optional类对象的方法：
    @Test
    public void test() {
//        Optional.of(T t) :创建一个 Optional 实例，t必须非空；
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> girl1 = Optional.of(girl); //抛出空指针异常

//        Optional.empty() :创建一个空的 Optional 实例
//        Optional.ofNullable(T t)：t可以为null
    }

    @Test
    public void test1(){
        //ofNullable(T t)：t可以为null
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);//Optional.empty

        //orElse(T t):如果当前的Optional内部封装的t是非空的，则返回t;
        //如果内部的t是空的，则返回orElse()方法中的参数
        Girl girl2 = girl1.orElse(new Girl("UI"));
        System.out.println(girl2);
    }

    //避免空指针异常
    public String getGirlName(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null){
                girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test2(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //使用Optional避免空指针异常
    public String getGirlName1(Boy boy){

        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("Mary")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("古力娜扎"));

        return girl2.getName();
    }

    @Test
    public void test3(){
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("佟丽娅"));
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

}
