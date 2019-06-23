package com.ibeetl.java8.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

/**
 * LocalDate LocalTime LocalDateTime
 * Instant:时间戳 （以Unix元年 1970年1月1日 00:00:00 到此时的毫秒值
 * Duration:计算两个时间之间的间隔
 * Period：计算两个日期之间的间隔
 * TemporalAdjuster:时间较正器
 * DateTimeFormat:用于格式化时间或日期
 * ZonedDate、ZonedTime、ZonedDateTIme :时区
 * @author yuzhen
 *
 */
public class DateAPI {
	
	@Test
	public void test7() {
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Monaco"));
		System.out.println(ldt);
		
		LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Europe/Monaco"));
		ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Europe/Monaco"));
		System.out.println(zdt);
	}
	
	@Test
	public void test6(){
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime ldt = LocalDateTime.now();
		
		String strDate = ldt.format(dtf);
		System.out.println(strDate);
		System.out.println("-----------------");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
		String strDate2 = dtf2.format(ldt);
		System.out.println(strDate2);
		System.out.println("-----------------");
		LocalDateTime newDate = ldt.parse(strDate2,dtf2);
		System.out.println(newDate);
	}
	
	@Test
	public void test5() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		LocalDateTime ldt2 = ldt.withDayOfMonth(10);
		System.out.println(ldt2);
		LocalDateTime ldt3 = ldt2.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println(ldt3);
		//自定义到下一个工作日
		LocalDateTime ldt5= ldt.with((l) -> {
			LocalDateTime ldt4 = (LocalDateTime) l;
			DayOfWeek dow = ldt4.getDayOfWeek();
			if(dow.equals(DayOfWeek.FRIDAY)) {
				return ldt4.plusDays(3);
			}else if(dow.equals(DayOfWeek.SATURDAY)) {
				return ldt3.plusDays(2);
			}else {
				return ldt4.plusDays(1);
			}
		});
		System.out.println(ldt5);
	}
	
	@Test
	public void test4() {
		LocalDate ld1 = LocalDate.now();
		LocalDate ld2 = LocalDate.of(2019, 6, 10);
		Period period = Period.between(ld1, ld2);
		System.out.println(period);
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
	}
	
	@Test
	public void test3() {
		Instant ins1 = Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant ins2 = Instant.now();
		Duration duration = Duration.between(ins1, ins2);
		System.out.println(duration.getSeconds());
		System.out.println(duration.toMillis());
		System.out.println("------两个时间的间隔----------");
		LocalTime lt1 = LocalTime.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LocalTime lt2 = LocalTime.now();
		Duration duration2 = Duration.between(lt1, lt2);
		System.out.println(duration2.toMillis());
		
	}
	
	@Test
	public void test2() {
		Instant ins1 = Instant.now();//默认获取UTC时区
		System.out.println(ins1);
		
		OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		
		System.out.println(ins1.toEpochMilli());//这u是时间戳
		Instant ins2 = Instant.ofEpochSecond(1000);
		System.out.println(ins2);
		
	}
	
	@Test
	public void test1() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ldt2 = LocalDateTime.of(2019, 6, 16, 18, 00, 12, 33);
		System.out.println(ldt2);
		
		LocalDateTime ldt3 = ldt.plusYears(2);
		System.out.println(ldt3);
		
		LocalDateTime ldt4 = ldt.minusMonths(2);
		System.out.println(ldt4);
		
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
		
	}
}
