package cnn.whoops.lambda.stream;

import cnn.whoops.lambda.method.Employee;
import cnn.whoops.lambda.method.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: whoops
 * @date: 2021/8/5 - 15:03
 * @description:
 *
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *
 *  1- 创建 Stream
 * 一个数据源（如：集合、数组），获取一个流
 *  2- 中间操作
 * 一个中间操作链，对数据源的数据进行处理
 *  3- 终止操作(终端操作) 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 */
public class StreamTest {

    //创建Stram方式一：通过集合
    @Test
    public void test(){

        List<Employee> list = EmployeeData.getEmployees();
//      default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = list.stream();

//      default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = list.parallelStream();
    }

    //创建 Stream方式二：通过数组
    @Test
    public void test1(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arr);
        //自定义数组
        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jack");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建 Stream方式三：通过Stream的of()
    @Test
    public void test2(){
        //public static<T> Stream<T> of(T... values) : 返回一个流
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    //创建 Stream方式四：创建无限流
    @Test
    public void test3(){
//        迭代
//        public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历10个偶数
//        Stream.iterate(0,t -> t + 2).limit(10).forEach(s -> System.out.println(s));
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);

//         生成
//        public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
