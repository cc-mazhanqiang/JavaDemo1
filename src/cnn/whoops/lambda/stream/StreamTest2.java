package cnn.whoops.lambda.stream;

import cnn.whoops.lambda.method.Employee;
import cnn.whoops.lambda.method.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: whoops
 * @date: 2021/8/5 - 21:50
 * @description:
 *
 * Stream的终止操作
 *
 */
public class StreamTest2 {
//    1-匹配与查找
    @Test
    public void test(){
        List<Employee> employees = EmployeeData.getEmployees();
//        allMatch(Predicate p):检查是否匹配所有元素
        //练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        System.out.println();

//        anyMatch(Predicate p):检查是否至少匹配一个元素
        //练习：是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(allMatch);

        System.out.println();

//        noneMatch(Predicate p):检查是否没有匹配所有元素
        //练习：是否存在员工姓"雷"
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        System.out.println();

//        findFirst():返回第一个元素
        Optional<Employee> first = employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).findFirst();
        System.out.println(first);
//        findAny():返回当前流中的任意元素
        //employees.stream():串行流
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        //employees.parallelStream():并行流
        Optional<Employee> any1 = employees.parallelStream().findAny();
        System.out.println(any1);

        System.out.println();

//        count():返回流中元素总数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
//        max(Comparator c):返回流中最大值
        //练习：返回最高的工资
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = doubleStream.max((e1,e2) -> e1.compareTo(e2));
//        Optional<Double> max1 = doubleStream.max(Double::compareTo);
        System.out.println(max);
//        min(Comparator c):返回流中最小值
        //练习：返回最低的工资
        Stream<Double> doubleStream1 = employees.stream().map(e -> e.getSalary());
        Optional<Double> min = doubleStream1.min((e1, e2) -> e1.compareTo(e2));
//        Optional<Double> min1 = doubleStream1.min(Double::compareTo);
        System.out.println(min);
        System.out.println();
        Optional<Employee> min1 = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min1);

        System.out.println();

//        forEach(Consumer c):内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭 代——它帮你把迭代做了)
        employees.stream().forEach(System.out::println);
        System.out.println();
        //使用集合的迭代
        employees.forEach(System.out::println);
    }

//    2-归约
    @Test
    public void test1(){
//        reduce(T iden, BinaryOperator b):可以将流中元素反复结合起来，得到一 个值。返回 T
        //练习：计算1-10的自然数之和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

//        reduce(BinaryOperator b):可以将流中元素反复结合起来，得到一 个值。返回 Optional<T>
        //练习：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
//        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
//        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        Optional<Double> reduce1 = doubleStream.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce1);
    }

//    3-收集
    @Test
    public void test3(){
//        collect(Collector c):将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法
        //练习：查找工资大于6000的员工，结果返回一个List或Set集合
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println();
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
        System.out.println();
//        ArrayList<Employee> employeeArrayList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toCollection(() -> new ArrayList<>()));
        ArrayList<Employee> employeeArrayList1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toCollection(ArrayList::new));
        employeeArrayList1.forEach(System.out::println);
    }
}
