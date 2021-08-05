package cnn.whoops.lambda.method;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * <p>
 * 二、数组引用
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    @Test
    public void test1() {
        Supplier<Employee> sups = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sups.get());

        System.out.println("******************************");

        Supplier<Employee> sup = () -> new Employee();
        System.out.println(sup.get());

        System.out.println("******************************");

        Supplier<Employee> sup1 = Employee::new;
        System.out.println(sup1.get());

    }

    //Function中的R apply(T t)
    @Test
    public void test2() {
        Function<Integer,Employee> fun = (id) -> new Employee(id);
        System.out.println(fun.apply(1001));
        System.out.println("*******************************");
        Function<Integer,Employee> fun1 = Employee :: new;
        System.out.println(fun1.apply(1002));
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3() {
        BiFunction<Integer,String,Employee> fun = (id,name) -> new Employee(id,name);
        System.out.println(fun.apply(1001,"Tom"));
        System.out.println("*******************************");
        BiFunction<Integer,String,Employee> fun1 = Employee :: new;
        System.out.println(fun.apply(1002,"Jack"));

    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {
        Function<Integer,String[]> fun = length -> new String[length];
        String[] arr = fun.apply(5);
        System.out.println(Arrays.toString(arr));
        System.out.println("**********************************");
        Function<Integer,String[]> fun1 = String[]::new;
        String[] arr1 = fun.apply(5);
        System.out.println(Arrays.toString(arr));
    }
}
