// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.
package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import triptypes.VacationPackage;
import triptypes.AllInclusiveResort;
//import triptypes.CabinType;
//import triptypes.Cruise;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;

public class FlightOptionalPackageTest 
{
	/**
	 * .	
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	@Test
	public void FlightOptionalPackageAddFlightLegMAXTest()
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
		
		Flight f = new Flight("ODR", 123, "OMA", "ATL", date1, date2, 2220.2);
		
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		
		assertTrue(((FlightOptionalPackage) a).hasFlights());
		
		Flight[] g = ((FlightOptionalPackage) a).getFlightItinerary();
		
		for(int i = 0; i < g.length; i++ )
		{
			System.out.print(i + " ");
			System.out.println(g[i].toString());
		}
		
	}
	

	@Test
	public void FlightOptionalPackageHasFlightNull()
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
		
		((FlightOptionalPackage) a).addFlightLeg(null);
		
		assertFalse(((FlightOptionalPackage) a).hasFlights());
			
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void FlightOptionalPackageGetFlightIteneraryNull()
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
		
		((FlightOptionalPackage) a).addFlightLeg(null);
		
		assertEquals(null,((FlightOptionalPackage) a).getFlightItinerary());
	}
	
	
	
	@Test
	public void FlightOptionalPackageGetFlightCosts()
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
		
		Flight f = new Flight("ODR", 123, "OMA", "ATL", date1, date2, 2220.2);
		
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		((FlightOptionalPackage) a).addFlightLeg(f);
		
		assertEquals(((FlightOptionalPackage) a).getFlightCosts(), 6660.6, DOUBLE_TOLERANCE);
	}
	
	@Test
	public void FlightOptionalPackageToStringHasFlight()
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
		
		Flight f = new Flight("ODR", 123, "OMA", "ATL", date1, date2, 2220.2);
		
		((FlightOptionalPackage) a).addFlightLeg(f);
		
		System.out.println(((FlightOptionalPackage) a).toString());
		
		assertEquals("$ 8220.20  Jacob (Flight Included)\n" +
				"           An all-inclusive stay at Stanley Hotel for 2 people!",((FlightOptionalPackage) a).toString());
	}
	
	@Test
	public void FlightOptionalPackageToStringNoFlight()
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
		
		System.out.println(((FlightOptionalPackage) a).toString());
		
		assertEquals("$ 6000.00  Jacob (Flight Not Included)\n" +
				"           An all-inclusive stay at Stanley Hotel for 2 people!",((FlightOptionalPackage) a).toString());
	}
	
}
