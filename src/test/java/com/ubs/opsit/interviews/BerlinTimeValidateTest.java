package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class BerlinTimeValidateTest {

	
	@Test
	public void timeValidatePositive1(){
		
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String aTime = "20:10:12";
		LocalTime  localTime= LocalTime.parse(aTime, timeFormatter);
		
		assertEquals( localTime, TimeUtil.validateTimeString(aTime));
		
	}
	
	@Test
	public void timeValidatePositive2(){
		
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String aTime = "23:59:59";
		LocalTime  localTime= LocalTime.parse(aTime, timeFormatter);
		
		assertEquals( localTime, TimeUtil.validateTimeString(aTime));
		
	}
	
	@Test
	public void timeValidatePositive3(){
		
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String aTime = "00:00:00";
		LocalTime  localTime= LocalTime.parse(aTime, timeFormatter);
		
		assertEquals( localTime, TimeUtil.validateTimeString(aTime));
		
	}
	
	@Test(expected = RuntimeException.class)
	 public void timeValidateNagative1(){
		TimeUtil.validateTimeString("25:00:00");
		
	}
	
	@Test(expected = RuntimeException.class)
	 public void timeValidateNagative2(){
		TimeUtil.validateTimeString("22:00:65");
		
	}
	
	@Test(expected = RuntimeException.class)
	 public void timeValidateNagative3(){
		TimeUtil.validateTimeString("22:70:00");
	}
	
	@Test(expected = RuntimeException.class)
	 public void timeValidateNagative4(){
		TimeUtil.validateTimeString("00:00:0");
	}
	
	@Test
	public void getHour_Minut(){
	
		String aTime1 = "20:10:12";
		int hour20 = 20;
		int minut10 = 10;
		assertEquals(hour20,TimeUtil.getHour(aTime1)); 
		assertEquals(minut10,TimeUtil.getMinute(getLocalTimeObject(aTime1))); 
		
		String aTime2 = "24:00:00";
		int hour24 = 24;
		int minut0 = 00;
		assertEquals(hour24,TimeUtil.getHour(aTime2)); 
		assertEquals(minut0,TimeUtil.getMinute(getLocalTimeObject(aTime2))); 
		
		
		String aTime3 = "00:00:00";
		int hour00 = 00;
		int minut00 = 00;
		assertEquals(hour00,TimeUtil.getHour(aTime3)); 
		assertEquals(minut00,TimeUtil.getMinute(getLocalTimeObject(aTime3))); 
		
		String aTime4 = "23:59:59";
		int hour23 = 23;
		int minut59 = 59;
		assertEquals(hour23,TimeUtil.getHour(aTime4)); 
		assertEquals(minut59,TimeUtil.getMinute(getLocalTimeObject(aTime4))); 

	}
	
	
	public LocalTime getLocalTimeObject(String aTime){
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return LocalTime.parse(aTime, timeFormatter);	
	}

}