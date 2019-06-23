package com.ibeetl.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * java8 内置的四大核心函数式接口
 * 
 * Consumer<T>:消费型接口
 * 	void accept(T t);
 * 
 * Supplier<T>:供给型接口
 * 	T get();
 * 
 * Function<T,R>:函数型接口
 * 	R apply(T,t);
 * 
 * Predicate<T>:断言型接口
 * 	boolean test(T t);
 * 
 * 还有一些扩展接口 实现方式式一样的
 */
public class LambdaFuncs {
	
	//Predicate<T> 断言型接口
	@Test
	public void test4() {
		List<String> list =Arrays.asList("Hello","abd","cdsweewwew");
		List<String> nList = filterStr(list,(s) -> s.length()>3);
		for(String str:nList) {
			System.out.println(str);
		}
	}
	public List<String> filterStr(List<String> list,Predicate<String> pre){
		List<String> strList = new ArrayList<>();
		for(String str:list) {
			if(pre.test(str)) {
				strList.add(str);
			}
		}
		return strList;
	}
	
	//Function 函数型接口  传进去一个对象 返回一个加工对象
	@Test
	public void test3() {
		String nstr = strHandler("/t/t/t 你好啊",(str) -> str.trim());
		System.out.println(nstr);
	}
	public String strHandler(String str,Function<String,String> fun) {
		return fun.apply(str);
	}
	
	//Supplier 供给型接口用于产生一些对象
	@Test
	public void test2() {
		getNumList(10,() -> (int)(Math.random() * 100));
	}
	public List<Integer> getNumList(int num,Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<num;i++) {
			Integer n = sup.get();
			list.add(n);
		}
		return list;
	}
	
	@Test
	//Consumer<T> 消费型接口 用户消费一些对象
	public void test1() {
		happy(10000,(m) -> System.out.println("每次消费:" + m ));
	}
	public void happy(double money,Consumer<Double> con) {
		con.accept(money);
	}
}
