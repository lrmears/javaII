// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.
package tests;

import static org.junit.Assert.*;
import triptypes.Flight;
import java.util.Calendar;


import org.junit.Test;

public class FlightTest 
{
	/**
	 * .
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;

	@Test
	public void flightConstructorPriceTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		Flight a = new Flight("ODR", 123, "OMA", "ATL", date1, date2, 2220.2);
		
		assertEquals(2220.2, a.getPrice(), DOUBLE_TOLERANCE);
		
		
	}
	
	
	
	@Test
	public void toStringFlightTest()
	{
		//STEP 1: Setup prior state of the object
		//Since we're testing a constructor here, this step is not applicable.
		
		Calendar date1 = Calendar.getInstance();
		
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		
		date2.set(2021, 02, 15, 18, 01);
		
		Flight a = new Flight("ODR", 123, "OMA", "ATL", date1, date2, 2220.2);
		
		System.out.println (a);
	
		assertEquals("ODR 123 Departs: OMA at 15:25 03-15-2021; Arrives ATL at 18:01 03-15-2021", a.toString());
		
	}

}
