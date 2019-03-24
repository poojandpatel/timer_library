package maxeta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTest_Standardtimer_std {

	Timer timer_std =  new Timer(false);
	
	/*
	 * after 12:00:00 hours, calling incrementHour() should change time to 01:00:00
	 */
	@Test
	void testIncrementHour_std() {
		timer_std.setHour(12);
		timer_std.incrementHour();
		assertEquals(1, timer_std.getHour());
	}
	
	/*
	 * increment min by doing calling increment seconds 60 times.
	 * initial timer_std will be set to 0:0:0 and final should be 0:1:0
	 */
	@Test
	void testIncrementSeconds_std() 
	{
		timer_std.setHour(1);
		timer_std.setMinutes(0);
		timer_std.setSeconds(0);
		//System.out.println("Initial Time: " + timer_std.getHour() + ":" + timer_std.getMinutes() + ":" + timer_std.getSeconds());
		for(int i = 1; i <= 60; i++) {
			timer_std.incrementSeconds();
			//System.out.println(i+": " + timer_std.getHour() + ":" + timer_std.getMinutes() + ":" + timer_std.getSeconds());
		}
		assertEquals(0, timer_std.getSeconds());
		assertEquals(1, timer_std.getMinutes());
		assertEquals(1, timer_std.getHour());
	}
	
	@Test
	void testIncrementSeconds_2_std() 
	{
		timer_std.setHour(12);
		timer_std.setMinutes(0);
		timer_std.setSeconds(0);
		//System.out.println("Initial Time: " + timer_std.getHour() + ":" + timer_std.getMinutes() + ":" + timer_std.getSeconds());
		for(int i = 1; i <= 3600; i++) {
			timer_std.incrementSeconds();
			//System.out.println(i+": " + timer_std.getHour() + ":" + timer_std.getMinutes() + ":" + timer_std.getSeconds());
		}
		assertEquals(1, timer_std.getHour());
		assertEquals(0, timer_std.getMinutes());
		assertEquals(0, timer_std.getSeconds());		
	}

	@Test
	void invalid_setHour_val_std()
	{
		assertThrows(IllegalArgumentException.class, () -> timer_std.setHour(25), "invalid hour value");
	}
	
	@Test
	void invalid_setMinutes_val_std()
	{
		assertThrows(IllegalArgumentException.class, () -> timer_std.setMinutes(61), "invalid minute value");
	}
	
	@Test
	void invalid_setSeconds_val_std()
	{
		assertThrows(IllegalArgumentException.class, () -> timer_std.setHour(61), "invalid second value");
	}

}
