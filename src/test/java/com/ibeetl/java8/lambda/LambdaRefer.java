package com.ibeetl.java8.lambda;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/**
 *一、方法引用：若lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 * （可以理解方法引用是Lambda表达式的另一种实现方式
 * 主要有三种语法格式：
 * 
 * 对象::实现方法名
 * 
 * 类::静态方法名
 * 
 * 类::实列方法名
 *
 *注意：
 *1：Lambda体中的调用参数列表与返回值类型，要与函数式接口的函数列表和返回值类型一致
 *2：若Lambda 参数列表中的第一参数是 实例方法的调用者，第二个参数是实例方法的参数时，可以使用 类::实例方法名
 *
 *二、构造器引用
 *
 *格式：
 *
 *ClassName::new
 *
 *注意：
 * 1：需要调用的构造器的参数列表，要与函数式接口的参数列表保持一致
 * 
 * 三、数组引用
 * 
 * Type::new;

 */
public class LambdaRefer {
	
	//对象::实现方法名
	@Test
	public void test() {
		PrintStream ps1 = System.out;
		Consumer<String> con = (x) -> ps1.println(x);
		//有个前提条件：实现方法名的参数类型个数、返回类型与Consumer的参数类型个数、返回类型必须一致
		PrintStream ps2 = System.out;
		Consumer<String> con1 = ps2::println;
		
		Consumer<String> con2 = System.out::println;
		con2.accept("abdef");
	}
	
	@Test
	public void test1() {
		Employee emp = new Employee();
		Supplier<String> sup = () -> emp.getName();
		String str = sup.get();
		System.out.println(str);
		
		Supplier<Integer> sup2 = emp::getAge;
		Integer num  = sup2.get();
		System.out.println(num);
	}
	
	//静态方法
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		
		Comparator<Integer> com1 = Integer::compare;
		com1.compare(4, 5);
	}
	
	//类::实例方法名
	@Test
	public void test4() {
		BiPredicate<String,String> bp = (x,y) -> x.equals(y);
		
		BiPredicate<String,String> bp2 = String::equals;
	}
	
	@Test
	public void test5() {
		Supplier<Employee> sup = () -> new Employee();
		//构造器引用方式
		Supplier<Employee> sup2 = Employee::new;
		Employee emp = sup2.get();
		emp.getName();
	}
	
	@Test
	public void test6() {
		Function<Integer,Employee> fun = (x) -> new Employee(x);
		
		Function<Integer,Employee> fun2 = Employee::new;
		Employee emp = fun2.apply(11);
		emp.getName();
		
	}
	
	@Test
	public void test7() {
		Function<Integer,String[]> fun = (x) -> new String[x];
		String[] strs = fun.apply(10);
		System.out.println(strs.length);
		
		Function<Integer,String[]> fun2 = String[]::new;
		String[] sts2 = fun2.apply(20);
		System.out.println(sts2.length);
	}
	

}
