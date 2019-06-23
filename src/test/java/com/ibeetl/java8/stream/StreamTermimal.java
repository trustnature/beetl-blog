package com.ibeetl.java8.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.ibeetl.java8.lambda.Employee;
import com.ibeetl.java8.lambda.Employee.Status;

/**
 * 终止操作
 *
 */
public class StreamTermimal {

	List<Employee> employees = Arrays.asList(
			new Employee("张三",18,9999.11,Status.FREE),
			new Employee("李四",20,6666.11,Status.BUSY),
			new Employee("王五",25,5555.11,Status.FREE),
			new Employee("赵六",30,4567.11,Status.VOCATION),
			new Employee("田七",40,2111.11,Status.BUSY)
	);
	
	/**
	 * 收集
	 * collect - 将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
	 */
	@Test
	public void test4() {
		List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
		list.forEach(System.out::println);
		System.out.println("--------------------------");
		Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toSet());
		set.forEach(System.out::println);
		System.out.println("--------------------------");
		HashSet<String> hs= employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
		hs.forEach(System.out::println);
		System.out.println("---------------------------");
		Long count = employees.stream().collect(Collectors.counting());
		System.out.println(count);
		System.out.println("---------------------------");
		Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		System.out.println("---------------------------");
		//总和
		Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		//最大值
		Optional<Employee> max = employees.stream().collect(Collectors.maxBy((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println(max.get());
		//最小值
		Optional<Double> min = employees.stream().map(Employee::getSalary)
		.collect(Collectors.minBy(Double::compare));
		System.out.println(min.get());
		//分组
		Map<Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map);
		//多级分组
		Map<Status,Map<String,List<Employee>>> map1 = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
			if(((Employee)e).getAge() <= 35){
				return "青年";
			}else {
				return "老年";
			}
		})));
		System.out.println(map1);
		//分区
		Map<Boolean,List<Employee>> map2 = employees.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 5000));
		System.out.println(map2);
	}	
	
	/**
	 * 	归约
	 * reduce(T identity,BinaryOprator)/reduce(BinaryOperator)
	 */
	@Test
	public void test2() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Integer sum = list.stream().reduce(0, (x,y) -> x+y);
		System.out.println(sum);
		System.out.println("----------------");
		Optional<Double> op = employees.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println(op.get());
	}
	
	/**
	 * 查找与匹配
	 * allMatch - 检查是否匹配所有元素
	 * anyMatch - 检查是否至少匹配一个元素
	 * noneMatch - 检查是否没有匹配所有元素
	 * findFirst - 返回第一个元素
	 * findAny -返回当前流中的任意元素
	 * count - 返回流中元素的总个数
	 * max - 返回流中最大值
	 * min - 返回流中最小值
	 */
	@Test
	public void test1() {
		boolean b1 = employees.stream()
		.allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);
		
		boolean b2 = employees.stream()
				.anyMatch((e)->e.getStatus().equals(Status.BUSY));
		System.out.println(b2);
		
		boolean b3 = employees.stream()
				.noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b3);
		
		Optional<Employee> op = employees.stream()
				.sorted((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()))
				.findFirst();
		System.out.println(op.get());
		
		Optional<Employee> op2 = employees.stream()
			.filter((e) -> e.getStatus().equals(Status.FREE))
			.findAny();
		System.out.println(op2.get());

		Long count = employees.stream()
		.count();
		System.out.println(count);
		
		Optional<Employee> op1 = employees.stream().max((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()));
		System.out.println(op1.get());
		
		Optional<Double> op3 = employees.stream().map(Employee::getSalary)
		.min(Double::compare);
		System.out.println(op2.get());
		
	}
}
