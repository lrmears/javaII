// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.
package tests;

import static org.junit.Assert.*;   // A Checkstyle error on this line is okay.

import org.junit.Test;

import java.util.Calendar;
import triptypes.VacationPackage;
import triptypes.AllInclusiveResort;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;

/**
 * Testing the all inclusive class.
 * @author lmears, jacobsand
 */
public class AllInclusiveResortTest 
{
	
	/**
	 * Test case.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	/**
	 * Test case.
	 */
	@Test
	public void AllInclusiveResortConstructorTest()
	{
		String[] amenities = new String[1];
		amenities[0] = "Hot Water";
		VacationPackage a = new AllInclusiveResort("Jacob", 5, "Stanley Hotel", 2, 1000, amenities);
		
		assertEquals("Jacob",a.getName());
		assertEquals(7, a.getNumDays());
		//assertEquals("Ritz Carlton", ((AllInclusiveResort) a).getResort());
		assertEquals(2,((AllInclusiveResort) a).getGuestsPerRoom());
		//assertEquals(1000, ((AllInclusiveResort) a).getPricePerNight());
		
		
	}
	
	/**
	 * .
	 */
	@d
	public void AllInclusiveResortGetAmenitiesTest()
	{
		
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		String[] amenities = new String[3];
		amenities[0] = "Hot water";
		amenities[1] = "Pool";
		amenities[2] = "Room service";
		
		VacationPackage a = new AllInclusiveResort("Jacob", 5, "Stanley Hotel", 2, 1000, amenities);
		
		assertEquals("Hot water, Pool, Room service", ((AllInclusiveResort) a).getAmenities());
	}
	
	/**
	 * .
	 */
	@Test
	public void AllInclusiveResortGetPrice()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		String[] amenities = new String[3];
		amenities[0] = "Hot water";
		amenities[1] = "Pool";
		amenities[2] = "Room service";
		
		VacationPackage a = new AllInclusiveResort("Jacob", 5, "Stanley Hotel", 2, 1000, amenities);
		
		Flight f = new Flight("ORD", 123, "OMA", "ATL", date1, date2, 2220.2);
		
		((FlightOptionalPackage) a).addFlightLeg(f);
		
		assertEquals(6000, ((AllInclusiveResort)a).getLodgingCost(), DOUBLE_TOLERANCE);
		
		assertEquals(8220.2, ((AllInclusiveResort) a).getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * .
	 */
	@Test
	public void AllInclusiveResortGetLodgingCost()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		String[] amenities = new String[3];
		amenities[0] = "Hot water";
		amenities[1] = "Pool";
		amenities[2] = "Room service";
		
		VacationPackage a = new AllInclusiveResort("Jacob", 5, "Stanley Hotel", 2, 1000, amenities);
		
		assertEquals(6000, ((AllInclusiveResort)a).getLodgingCost(), DOUBLE_TOLERANCE);
		
	}
	
	/**
	 * .
	 */
	@Test
	public void AllInclusiveResortGetDepositAmount()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		String[] amenities = new String[3];
		amenities[0] = "Hot water";
		amenities[1] = "Pool";
		amenities[2] = "Room service";
		
		VacationPackage a = new AllInclusiveResort("Jacob", 5, "Stanley Hotel", 2, 1000, amenities);
		
		Flight f = new Flight("ORD", 123, "OMA", "ATL", date1, date2, 2220.2);
		
		((FlightOptionalPackage) a).addFlightLeg(f);
		
		assertEquals(5220.2, ((AllInclusiveResort)a).getDepositAmount(), DOUBLE_TOLERANCE);
			
	}
	
	/**
	 * .
	 */
	@Test
	public void AllInclusiveResortToString()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		String[] amenities = new String[3];
		amenities[0] = "Hot water";
		amenities[1] = "Pool";
		amenities[2] = "Room service";
		
		VacationPackage a = new AllInclusiveResort("Jacob", 7, "Stanley Hotel", 2, 1000, amenities);
		
		assertEquals("$ 6000.00  Abdul (Flight Not Included)\n" 
				+	"           An all-inclusive stay at Ritz Carlton for 2 people!", 
				((AllInclusiveResort) a).toString());
			
	}

}
