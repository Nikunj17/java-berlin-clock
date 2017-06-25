package com.ubs.opsit.interviews;
import java.time.LocalTime;

/**
 * @author Nikunj Thoriya
 *
 */
public class BerlinTimeConverter implements TimeConverter {


	@Override
	public String convertTime(String aTime) {

		//Validate Time 
		LocalTime localTime= TimeUtil.validateTimeString(aTime);
		
		//GetBerlinTime
		BerlinTimeService berlinTime = new BerlinTimeService();
		
		return berlinTime.ConvertBerlinTime(localTime , aTime);
	}
}
