package cnn.whoops.lambda.method;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 类(或对象) :: 方法体
 * 对象 :: 非静态方法
 * 类 :: 静态方法
 * 类 :: 非静态方法
 *
 *
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con = str -> System.out.println(str);
		con.accept("中国");

		System.out.println("*********************************");
		PrintStream ps = System.out;
		Consumer<String> con1 = ps :: println;
//		Consumer<String> con2 = System.out :: println;
		con1.accept("北京");

	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001,"Tom",23,5000);
		Supplier<String> sup = () -> emp.getName();
		System.out.println(sup.get());
		System.out.println("*******************************************");

		Supplier<String> sup1 = emp :: getName;
		System.out.println(sup1.get());
	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com = (t1,t2) -> Integer.compare(t1,t2);
		System.out.println(com.compare(20,23));
		System.out.println("*******************************************");

		Comparator<Integer> com1 = Integer :: compare;
		System.out.println(com1.compare(12,10));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double,Long> fun = new Function<Double, Long>() {
			@Override
			public Long apply(Double aDouble) {
				return Math.round(aDouble);
			}
		};

		System.out.println("*************************");
		Function<Double,Long> fun1 = (d) -> Math.round(d);
		System.out.println(fun1.apply(15.4));

		System.out.println("*****************************");

		Function<Double,Long> fun2 = Math :: round;
		System.out.println(fun2.apply(15.4));

	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com = (t1,t2) -> t1.compareTo(t2);
		System.out.println(com.compare("abc","abd"));

		System.out.println("********************************");

		Comparator<String> com1 = String :: compareTo;
		System.out.println(com1.compare("abd","abm"));

	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String,String> bp = (t1,t2) -> t1.equals(t2);
		System.out.println(bp.test("abc","abc"));
		System.out.println("******************************");

		BiPredicate<String,String> bp1 = String :: equals;
		System.out.println(bp1.test("aaa","aaa"));

	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee emp = new Employee(1002,"Jack",20,50000);
		Function<Employee,String> fun = e -> e.getName();
		String name = fun.apply(emp);
		System.out.println(name);

		System.out.println("****************************************");

		Function<Employee,String> fun1 = Employee :: getName;
		System.out.println(fun1.apply(emp));

	}

}
