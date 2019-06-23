package com.ibeetl.java8.optional;

import java.util.Optional;

import org.junit.Test;

import com.ibeetl.java8.lambda.Employee;

/**
 * Optional 容器类的常用方法
 * Optional.of(T t)：创建一个Optional实例
 * Optional.empty():创建一个空的Optional实例
 * Optional.ofNullable(T t):若t不为null，创建Optional实例，否则创建空实例
 * isPresent():判断是否包含值
 * orElse(T t):如果调用对象包含值，返回该值，否则返回t
 * orElseGet(Supplier s)：如果调用对象为空值，返回该值，否则返回s获取的值
 * map(Function f):如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
 * flatMap(Function mapper)：与map类似，要求返回值必须是Optional
 *
 */
public class OptionalTest {
	
	@Test
	public void test4() {
		Optional<Employee> op = Optional.ofNullable(new Employee());
		Optional<String> str = op.map((e) -> e.getName());
		System.out.println(str.get());
		Optional<String> str2 = op.flatMap((e) -> Optional.of(e.getName()));
		System.out.println(str2.get());
	}
	
	@Test
	public void test3() {
		Optional<Employee> op = Optional.ofNullable(null);
		/*
		 * if(op.isPresent()) { System.out.println(op.get()); }
		 */
		Employee emp = op.orElse(new Employee());
		System.out.println(emp);
		//参数时函数式接口,可以定义任何想要的功能， 灵活性提高
		Employee emp2 = op.orElseGet(() -> new Employee());
		System.out.println(emp2);
	}
	
	@Test
	public void test2() {
		//允许构建一个空的Optional
		Optional<Employee> op = Optional.empty();
		System.out.println(op.get());
	}
	
	@Test
	public void test1() {
		//Optional<Employee> op = Optional.of(new Employee());
		Optional<Employee> op = Optional.of(null);//快速定为空指针异常
		Employee emp = op.get();
		System.out.println(emp);
	}
	
	//实例
	@Test
	public void test5() {
		/*
		 * Man man = new Man(); String n = getGodnessName(man); System.out.println(n);
		 */
		Optional<NewMan> op = Optional.ofNullable(null);
		System.out.println(getGodnessName2(op));
	}
	
	public String getGodnessName(Man man) {
		return man.getGodness().getName();
	}
	
	public String getGodnessName2(Optional<NewMan> man) {
		return man.orElse(new NewMan()).getGodness().orElse(new Godness("ww")).getName();
	}

}
