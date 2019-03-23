package poojan_patel_intern_project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class JUnitTest_MilitaryTimer {

	Timer timer;
	@Before 
	public void init() {
		timer = new Timer(true);
	}
	
	@Test
	void testSetHour() {
		timer.setHour(24);
		assertEquals(0, timer.getHour());
	}

}
