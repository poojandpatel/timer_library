package maxeta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class JUnitTest_MilitaryTimer {
	Timer timer =  new Timer(true);
	
	// tests if a IllegalArgumentException is thrown if invalid hour parameter is passed in
	@Test
	void invalid_setHour_val()
	{
		assertThrows(IllegalArgumentException.class, () -> timer.setHour(25), "invalid hour value");
	}


	// tests if a IllegalArgumentException is thrown if invalid minutes parameter is passed in
	@Test
	void invalid_setMinutes_val()
	{
		assertThrows(IllegalArgumentException.class, () -> timer.setMinutes(61), "invalid minute value");
	}
	
	// tests if a IllegalArgumentException is thrown if invalid seconds parameter is passed in
	@Test
	void invalid_setSeconds_val()
	{
		assertThrows(IllegalArgumentException.class, () -> timer.setHour(61), "invalid second value");
	}
	
	// tests the setHour method
	@Test	
	void testSetHour() {
		timer.setHour(24);
		assertEquals(0, timer.getHour());
	}
	
	@Test
	void testSetMinutes() {
		timer.setMinutes(60);
		assertEquals(1, timer.getHour());
	}
	
	/*
	 * resets minutes to 0, set it's to 60 which should increment the hour by one
	 */
	@Test
	void testSetMinutes2()
	{
		int tempHour = timer.getHour();
		timer.setMinutes(60);
		assertEquals(0, timer.getMinutes());
		assertEquals(tempHour+1, timer.getHour());
	}
	
	/*
	 * seconds should be reset to 0 after the 59th second and increment the minutes
	 */
	@Test
	void testSetSeconds() {
		int tempMin = timer.getMinutes();
		timer.setSeconds(60);
		assertEquals(0, timer.getSeconds());
		assertEquals(tempMin+1, timer.getMinutes());
	}
	
	/*
	 * increment hour by doing calling increment minutes 60 times.
	 * initial timer will be set to 0:0:0 and final should be 1:0:0
	 */
	@Test
	void testIncrementMinutes() 
	{
		timer.setHour(0);
		timer.setMinutes(0);
		timer.setSeconds(0);
		//System.out.println("Initial Time: " + timer.getHour() + ":" + timer.getMinutes() + ":" + timer.getSeconds());
		for(int i = 1; i <= 60; i++) {
			timer.incrementMinutes();
			//System.out.println(i+": " + timer.getHour() + ":" + timer.getMinutes() + ":" + timer.getSeconds());
		}
		assertEquals(0, timer.getSeconds());
		assertEquals(0, timer.getMinutes());
		assertEquals(1, timer.getHour());
	}
	
	/*
	 * increment min by doing calling increment seconds 60 times.
	 * initial timer will be set to 0:0:0 and final should be 0:1:0
	 */
	@Test
	void testIncrementSeconds() 
	{
		timer.setHour(0);
		timer.setMinutes(0);
		timer.setSeconds(0);
		//System.out.println("Initial Time: " + timer.getHour() + ":" + timer.getMinutes() + ":" + timer.getSeconds());
		for(int i = 1; i <= 60; i++) {
			timer.incrementSeconds();
			//System.out.println(i+": " + timer.getHour() + ":" + timer.getMinutes() + ":" + timer.getSeconds());
		}
		assertEquals(0, timer.getSeconds());
		assertEquals(1, timer.getMinutes());
		assertEquals(0, timer.getHour());
	}
	
	/*
	 * increment hour by doing calling increment seconds 2400 times.
	 * initial timer will be set to 0:0:0 and final should be 1:0:0
	 */
	@Test
	void testIncrementSeconds_2() 
	{
		timer.setHour(0);
		timer.setMinutes(0);
		timer.setSeconds(0);
		//System.out.println("Initial Time: " + timer.getHour() + ":" + timer.getMinutes() + ":" + timer.getSeconds());
		for(int i = 1; i <= 3600; i++) {
			timer.incrementSeconds();
			//System.out.println(i+": " + timer.getHour() + ":" + timer.getMinutes() + ":" + timer.getSeconds());
		}
		assertEquals(1, timer.getHour());
		assertEquals(0, timer.getMinutes());
		assertEquals(0, timer.getSeconds());		
	}
}

