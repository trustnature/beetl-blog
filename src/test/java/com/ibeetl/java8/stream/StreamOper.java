package com.ibeetl.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.ibeetl.java8.lambda.Employee;
import com.ibeetl.java8.lambda.Employee.Status;

/**
 * 流的中间操作
 *
 */
public class StreamOper {
	
	List<Employee> employees = Arrays.asList(
			new Employee("张三",18,9999.11,Status.FREE),
			new Employee("李四",20,6666.11,Status.BUSY),
			new Employee("王五",25,5555.11,Status.FREE),
			new Employee("赵六",30,4567.11,Status.VOCATION),
			new Employee("田七",40,2111.11,Status.BUSY)
	);
	
	/**
	 * 筛选与切片
	 * fiter-接收Lambda,从流中排除某些元素
	 * limit-截断流，使其元素不超过给定数量
	 * skip(n)-跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n,则返回一个空流，与limit(n)互补
	 * distinct-筛选，通过流所生成元素的hashCode()和equals()去除重复元素
	 */
	@Test
	public void test4() {
		employees.stream()
			.filter((e) -> e.getSalary() > 5000)
			.skip(2)
			.distinct()
			.forEach(System.out::println);
	}
	
	@Test
	public void test3() {
		employees.stream()
		.filter((e) -> {
			System.out.println("短路");//类似于 break
			return e.getSalary() > 5000;
		})
		.limit(2)
		.forEach(System.out::println);
	}
	
	//内部迭代：迭代操作由Stream API 完成
	@Test
	public void test1() {
		//中间操作  不会执行任何操作
		Stream<Employee> stream = employees.stream().filter((e) -> {
			System.out.println("Steam API 的中间操作");
			return e.getAge() > 35;
		});
		
		//终止操作：一次性执行全部内容，称之为 ”惰性求值“
		stream.forEach(System.out::println);
	}
	
	//外部迭代
	@Test
	public void test2() {
		Iterator<Employee> it = employees.iterator();
	}

	/**
	 * 映射
	 * map-接收Lambda,将元素转换成其他形式或提取信息,该函数会被应用到每个元素上，并将其映射成一个新的元素
	 * flatMap-接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流链接成一个流,类似与集合list.add和list.addall
	 */
	@Test
	public void test5() {
		List<String> list=Arrays.asList("aaa","bbb","cccc");
		list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
		System.out.println("---------------------");
		employees.parallelStream().map(Employee::getName).forEach(System.out::println);
		
		Stream<Stream<Character>> stream = list.stream().map(StreamOper::filterCharacter);
		
		stream.forEach((sm) -> {
			sm.forEach(System.out::println);
		});
		
		System.out.println("-------------------");
		Stream<Character> stream2 = list.stream().flatMap(StreamOper::filterCharacter);
		stream2.forEach(System.out::println);
	}
	
	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for(Character ch : str.toCharArray()) {
			list.add(ch);
		}
		return list.stream();
	}
	
	/**
	 * Stream 排序
	 */
	@Test
	public void test6() {
		List<String>  list = Arrays.asList("aaa","bbb","ccc");
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("----------------");
		employees.stream().sorted((e1,e2) -> {
			if(e1.getAge()>e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return e1.getName().compareTo(e2.getName());
			}
		});
	}
}
