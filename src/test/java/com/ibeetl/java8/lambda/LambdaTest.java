package com.ibeetl.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import com.ibeetl.java8.lambda.Employee.Status;

/**
 * lambda表达式需要函数式接口的支持
 * 函数式接口：接口中只有一个抽象方法时。可以使用 @FunctionalInterface接口修饰，检测是否是函数式接口
 */
public class LambdaTest {
	
	@Test
	//lambda表达式与 匿名内部类有密切联系
	public void TestLambda() {
		int num = 0 ;//final 
		//匿名内部类 无函数式Runnable接口的实现
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world!" + num);
			}
		};
		r.run();
		System.out.println("----------lambda-------------");
		//使用lambda表达式实现 参数为空时，需用（）
		Runnable r1 = () -> System.out.println("Hello Lambda!");
		r1.run();
	}
	
	@Test
	public void test1() {
		//如果 参数只有一个 可以省略 （），左侧参数列表 右侧是实现功能
		Consumer<String> c = x -> System.out.println(x);
		c.accept("有一个参数");
	}
	
	@Test
	public void test2() {
		//多条语句需要 {}
		Comparator<Integer> com = (x,y) -> {
			System.out.println("两个参数多条语句");
			return Integer.compare(x, y);
		};
		//如果只有一条语句 {和return 都可以不写
		//表达式的参数列表的数据类型可以省略不写，编译器可以通过上下文类型推断出来 叫做 “类型推断”
		Comparator<Integer> com1 = (x,y) -> Integer.compare(x, y);
		com.compare(3, 4);
	}
	
	@Test
	public  void test3() {
		Integer num = operation(100,(x) -> x * x);
		System.out.println(num);
	}
	public Integer operation(Integer num,MyFun mf) {
		return mf.getValue(num);
	}
	
	@Test
	public void test4() {
		List<Employee> emps = Arrays.asList(
				new Employee("张三",18,9999.11,Status.FREE),
				new Employee("李四",20,6666.11,Status.BUSY),
				new Employee("王五",25,5555.11,Status.FREE),
				new Employee("赵六",30,4567.11,Status.VOCATION),
				new Employee("田七",40,2111.11,Status.BUSY)
		);
		
		Collections.sort(emps,(e1,e2) -> {
			if(e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		for(Employee emp : emps) {
			System.out.println(emp);
		}
	}
	
	@Test
	//lambda 表达式传递
	public void test5() {
		//去空格
		String triStr = strHandler("\t\t\t 设计模式策略模式",str -> str.trim());
		System.out.println(triStr);

		//转大写
		String triStr2 = strHandler("abc123A",str -> str.toUpperCase());
		System.out.println(triStr2);
	}
	public String strHandler(String str,MyFun2 mf) {
		return mf.getValue(str);
	}
	
	@Test
	public void test6(){
		op(100L,200L,(x,y) -> x+y);
		op(100L,200L,(x,y) -> x*y);
	}
	//虽然使用lambda表达式 还需要创建函数式接口，但是JDK已提供常用接口了
	public void op(Long l1,Long l2,MyFun3<Long,Long> mf) {
		System.out.println(mf.getValue(l1, l2));
	}
	
}
