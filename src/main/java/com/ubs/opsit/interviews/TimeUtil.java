package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Nikunj Thoriya
 *
 */
public class TimeUtil {

	private static final Logger LOG = LoggerFactory.getLogger(TimeUtil.class);
	
	private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	
	public static LocalTime validateTimeString(String aTime){ //throws DateTimeParseException{
		LocalTime localTime = null;	    
		try {		 
			
			localTime = LocalTime.parse(aTime, timeFormatter);
			
			} catch (DateTimeParseException e) {
				
			LOG.error("Incorrect time format: "  +  e.getMessage());  
			throw new RuntimeException(" Incorrect time format: "  +  e.getMessage());  
		
			}
		return localTime ;

	}
	
	public static int getSecond(LocalTime aTime){
		return aTime.getSecond();
	}
		
	public static int getMinute(LocalTime aTime){
		return aTime.getMinute();
	}
	
	public static int getHour(String stringTime){
		
		TemporalAccessor parsed = timeFormatter.parse(stringTime);
		Period extraDays = parsed.query(DateTimeFormatter.parsedExcessDays());	
		if(extraDays.getDays()== 1){
			return 24;
		}else {
			return parsed.query(LocalTime::from).getHour();
		} 
	}
}


