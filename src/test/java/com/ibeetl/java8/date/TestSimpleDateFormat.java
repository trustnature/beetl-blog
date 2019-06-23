package com.ibeetl.java8.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * 传统的时间API 存在多线程安全问题
 * @author yuzhen
 *
 */
public class TestSimpleDateFormat {
	
	//传统方式解决线程安全
	@Test
	public void test1() throws InterruptedException, ExecutionException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				//return DateFormatThreadLocal.convert("20190615");  //线程安全
				return sdf.parse("20190615");
			}
			
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<Date>> results = new ArrayList();
		for(int i = 0; i < 20; i++) {
			results.add(pool.submit(task));
		}
		
		for(Future<Date> future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}
	
	//java8 线程安全
	@Test
	public void test2() throws InterruptedException, ExecutionException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyMMdd");
		Callable<LocalDate> task = new Callable<LocalDate>() {
			@Override
			public LocalDate call() throws Exception {
				return LocalDate.parse("20190615",dtf);
			}
			
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<LocalDate>> results = new ArrayList();
		for(int i = 0; i < 20; i++) {
			results.add(pool.submit(task));
		}
		
		for(Future<LocalDate> future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}
	
	
}
