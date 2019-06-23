package com.ibeetl.java8.lambda;

@FunctionalInterface
public interface MyFun3<T,R> {
	public R getValue(T t1,T t2);
}
