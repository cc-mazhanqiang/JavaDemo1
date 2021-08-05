package cnn.whoops.lambda.stream;

import cnn.whoops.lambda.method.Employee;
import cnn.whoops.lambda.method.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: whoops
 * @date: 2021/8/5 - 20:52
 * @description:
 *
 * Stream的中间操作
 *
 */
public class StreamTest1 {

    //1-筛选与切片
    @Test
    public void test() {
//    filter(Predicate p)：接收 Lambda ， 从流中排除某些元素
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println();

//    limit(long maxSize)：截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();

//    skip(long n)：跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一 个空流。与 limit(n) 互补
        list.stream().skip(3).forEach(System.out::println);

        System.out.println();

//    distinct()：筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.add(new Employee(1010, "张三", 40, 9000));
        list.add(new Employee(1010, "张三", 40, 9000));
        list.add(new Employee(1010, "张三", 40, 9000));
        list.add(new Employee(1010, "张三", 40, 9000));
        list.add(new Employee(1010, "张三", 40, 9000));
//        System.out.println(list);
        list.stream().distinct().forEach(System.out::println);
    }

    //2-映射
    @Test
    public void test1() {
//        map(Function f)：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        System.out.println();

//        练习1：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(e -> e.getName());
        nameStream.filter(nameStr -> nameStr.length() >= 3).forEach(System.out::println);

        System.out.println();

        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest1::fromStringToString);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println();
//        flatMap(Function f)：接收一个函数作为参数，将流中的每个值都换成另 一个流，然后把所有流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamTest1::fromStringToString);
        characterStream.forEach(System.out::println);

        System.out.println();
    }

    public static Stream<Character> fromStringToString(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();

    }

    //3-排序
    @Test
    public void test2() {
//        sorted():产生一个新流，其中按自然顺序排序(自然排序)
        List<Integer> list = Arrays.asList(25, 23, 98, -79, 0, 56, 10, -10);
        list.stream().sorted().forEach(System.out::println);

        //抛出类转换异常：ClassCastException，原因是Emloyee类没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);
        System.out.println();

//        sorted(Comparator com):产生一个新流，其中按比较器顺序排序(定制排序)
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).forEach(System.out::println);

        System.out.println();

        //如果年龄相等的情况下比较工资的大小,默认从小到大
        employees.stream().sorted((e1, e2) -> {
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare != 0) {
                return compare;
            } else {
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);

    }

}
