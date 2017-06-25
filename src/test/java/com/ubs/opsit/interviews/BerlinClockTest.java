package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BerlinClockTest {

	TimeConverter  berlinTimeConverter =  new BerlinTimeConverter();
	String nextLine = System.getProperty("line.separator"); 
	
	@Test
	public void BerlinTimeTest1() {
		
		String aTime = "00:00:00";		
		/*Y
		OOOO
		OOOO
		OOOOOOOOOOO
		OOOO
		*/
		String actualFormat =  "Y" +
					nextLine + "OOOO" + 
					nextLine + "OOOO" + 
					nextLine + "OOOOOOOOOOO" + 
					nextLine + "OOOO" ; 

		assertEquals(berlinTimeConverter.convertTime(aTime),actualFormat);
	}

	@Test
	public void BerlinTimeTest2() {
		
		String aTime = "13:17:01";		
		/*O
		RROO
		RRRO
		YYROOOOOOOO
		YYOO
		*/
		String actualFormat =  "O" +
					nextLine + "RROO" + 
					nextLine + "RRRO" + 
					nextLine + "YYROOOOOOOO" + 
					nextLine + "YYOO" ; 

		assertEquals(berlinTimeConverter.convertTime(aTime),actualFormat);
	}

	
	@Test
	public void BerlinTimeTest3() {
		
		String aTime = "23:59:59";		
		/*O
		RRRR
		RRRO
		YYRYYRYYRYY
		YYYY
		*/
		String actualFormat =  "O" +
					nextLine + "RRRR" + 
					nextLine + "RRRO" + 
					nextLine + "YYRYYRYYRYY" + 
					nextLine + "YYYY" ; 

		assertEquals(berlinTimeConverter.convertTime(aTime),actualFormat);
	}
	
	
	@Test
	public void BerlinTimeTest4() {
		
		String aTime = "24:00:00";		
		/*Y
		RRRR
		RRRR
		OOOOOOOOOOO
		OOOO
		*/
		String actualFormat =  "Y" +
					nextLine + "RRRR" + 
					nextLine + "RRRR" + 
					nextLine + "OOOOOOOOOOO" + 
					nextLine + "OOOO" ; 

		assertEquals(berlinTimeConverter.convertTime(aTime),actualFormat);
	}
}
