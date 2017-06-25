package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Nikunj Thoriya
 *
 */
public class BerlinTimeService {

	private static final Logger LOG = LoggerFactory.getLogger(BerlinTimeService.class);	
	
	public BerlinTimeService() {
	}
	
	public String ConvertBerlinTime(LocalTime aTime, String aTimeString){	
		
		StringBuffer berlinTime = new StringBuffer();
		
		int clockHour = TimeUtil.getHour(aTimeString);
		int clockMinut = TimeUtil.getMinute(aTime);
		int clockSecond = TimeUtil.getSecond(aTime);
		
		int BerlinClockHourFirstLine = clockHour/5 ;
		int BerlinClockHourSecondLine = clockHour%5 ;
		int BerlinClockMinutFirstLine = clockMinut/5 ;
		int BerlinClockMinutSecondLine = clockMinut%5 ;
		boolean BerlinClockFirstLine = clockSecond%2 == 0 ? true : false  ; 

		
		//Prepare clock top line
		berlinTime.append( BerlinClockFirstLine ? BerlinTimeConstant.ON_STATUS : BerlinTimeConstant.OFF_STATUS );
		berlinTime.append(System.getProperty("line.separator"));
		
		//Prepare clock first hour line
		berlinTime.append(BerlinTimeLineFormatter( BerlinClockHourFirstLine,BerlinTimeConstant.HOUR_FIRST_SECOND_LINE_PATTERN));
		berlinTime.append(System.getProperty("line.separator"));
		
		//Prepare clock second hour line
		berlinTime.append(BerlinTimeLineFormatter( BerlinClockHourSecondLine,BerlinTimeConstant.HOUR_FIRST_SECOND_LINE_PATTERN));
		berlinTime.append(System.getProperty("line.separator"));
		
		//Prepare clock first minut line
		berlinTime.append(BerlinTimeLineFormatter( BerlinClockMinutFirstLine,BerlinTimeConstant.MINUT_FIRST_LINE_PATTERN));
		berlinTime.append(System.getProperty("line.separator"));
		
		//Prepare clock second minut line
		berlinTime.append(BerlinTimeLineFormatter( BerlinClockMinutSecondLine,BerlinTimeConstant.MINUT_SECOND_LINE_PATTERN));
				
		System.out.println(berlinTime.toString());
		LOG.info("Berlin Time for : " + aTimeString  + berlinTime.toString());  
		
		
		return berlinTime.toString();
	}

	
	private char[] BerlinTimeLineFormatter(int clockLineValue , String lineFormatterPatter){
		char[] ClockLinelinePattern = lineFormatterPatter.toCharArray();
		Arrays.fill(ClockLinelinePattern, clockLineValue , ClockLinelinePattern.length, BerlinTimeConstant.OFF_STATUS);
		
		return ClockLinelinePattern ;
	}
	
}
