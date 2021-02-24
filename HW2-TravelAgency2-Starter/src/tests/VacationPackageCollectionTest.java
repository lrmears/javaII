// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.
package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import travelgui.VacationPackageCollection;
import triptypes.AllInclusiveResort;
import triptypes.FlightOptionalPackage;
import triptypes.RoadTrip;
import triptypes.Cruise;
import triptypes.Flight;
import triptypes.VacationPackage;


public class VacationPackageCollectionTest 
{
	/**
	 * .
	 */
	@Test
	public void VacationPackageCollectionConstructorTest()
	{
		VacationPackageCollection a = new VacationPackageCollection();
	
		assertEquals(0, a.getNumTrips());
	}
	
	@Test
	public void VacationPackageCollectionAddVacationTest()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		
		String[] amenities = new String[1];
		amenities[0] = "Hot Water";
		
		VacationPackage b = new AllInclusiveResort("Jacob", 7, "Stanley Hotel", 2, 1000, amenities);
		
		a.addVacation(b);
		
		assertEquals(1, a.getNumTrips());
		
		a.addVacation(b);
		
		assertEquals(2, a.getNumTrips());
		
		for (int i = 0; i < 25; i++)
		{
			a.addVacation(b);
		}
		
		assertEquals(25, a.getNumTrips());
		
		a.addVacation(b);
		
		assertEquals(25, a.getNumTrips());
	}
	
	@Test
	public void VacationPackageCollectionGetAllVacations()
	{
		
		VacationPackageCollection a = new VacationPackageCollection();
		
		String[] amenities = new String[1];
		amenities[0] = "Hot Water";
		
		VacationPackage b = new AllInclusiveResort("Jacob", 7, "Stanley Hotel", 2, 1000, amenities);
		
		a.addVacation(b);
		
		VacationPackage [] g = a.getAllVacations();
		
		assertEquals("Jacob", g[0].getName());
		
		VacationPackage f = a.getItemAt(0);
		
		assertEquals("Jacob",f.getName());
		
	}
	
	
	
	@Test
	public void VacationPackageCollectionGetFLightDetailsTest()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		
		String[] amenities = new String[1];
		amenities[0] = "Hot Water";
		
		VacationPackage b = new AllInclusiveResort("Jacob", 7, "Stanley Hotel", 2, 1000, amenities);
		
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		Flight f = new Flight("ODR", 123, "OMA", "ATL", date1, date2, 2220.2);
		
		((FlightOptionalPackage) b).addFlightLeg(f);
		
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		a.addVacation(b);
		

		System.out.println(a.getFlightDetails(0));
		
		assertEquals("ODR 123 Departs: OMA at 15:25 03-15-2021; "
				+ "Arrives ATL at 18:01 03-15-2021\n",a.getFlightDetails(0));
		assertEquals("ODR 123 Departs: OMA at 15:25 03-15-2021; "
				+ "Arrives ATL at 18:01 03-15-2021\n",a.getFlightDetails(11));
		
	}
	
	
	@Test
	public void VacationPackageCollectionGetFlightDetailsRoadTripTest()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		String[] stops = new String[1];
		stops[0] = "Gas Station";
		VacationPackage b = new RoadTrip("Road Trip", 1, stops, 1.00, 18, 1, 7);
		
		a.addVacation(b);
		String flightdeets = a.getFlightDetails(0);
		
		assertTrue(flightdeets.equals("ERROR: No flights are allowed for this type of trip!"));
		
	}
	

	
	@Test
	public void VacationPackageCollectionGetFlightDetailsIndexOutOfRangeLowTest()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		String[] stops = new String[1];
		stops[0] = "Gas Station";
		VacationPackage b = new RoadTrip("Road Trip", 1, stops, 1.00, 18, 1, 7);
		
		a.addVacation(b);
		String flightdeets = a.getFlightDetails(-1);
		
		assertTrue(flightdeets.equals("ERROR: Index is out of range!"));
		
	}
	
	@Test
	public void VacationPackageCollectionGetFlightDetailsIndexOutOfRangeHighTest()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		String[] stops = new String[1];
		stops[0] = "Gas Station";
		VacationPackage b = new RoadTrip("Road Trip", 1, stops, 1.00, 18, 1, 7);
		
		a.addVacation(b);
		String flightdeets = a.getFlightDetails(13);
		
		assertTrue(flightdeets.equals("ERROR: Index is out of range!"));
		
	}
	
	@Test
	public void VacationPackageCollectionGetFlightDetailsNoFlightTest()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage b = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		a.addVacation(b);
		
		assertEquals("ERROR: The selected trip has no flight information." ,  a.getFlightDetails(0));
		
	}
	


	@Test
	public void VacationPackageCollectionFilterVacationsTest()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage b = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		a.addVacation(b);

		String[] stops = new String[1];
		stops[0] = "Gas Station";
		VacationPackage c = new RoadTrip("Road Trip", 1, stops, 1.00, 18, 1, 7);
		
		a.addVacation(c);
		
		VacationPackageCollection x = a.filterVacationsFor(2);
		
		assertTrue(x.getItemAt(0) instanceof triptypes.Cruise);
		
		x = a.filterVacationsFor(1);
		
		assertTrue(x.getItemAt(0) instanceof triptypes.RoadTrip);
		
		String [] amenities = new String[1];
		amenities[0] = "Hot Water";
		VacationPackage d = new AllInclusiveResort("Jacob", 7, "Stanley Hotel", 2, 1000, amenities);
		
		a.addVacation(d);
		
		x = a.filterVacationsFor(3);
		
		assertTrue(x.getItemAt(0) instanceof AllInclusiveResort);
		
		x = a.filterVacationsFor(4);
		
		assertFalse(x.getItemAt(0) instanceof AllInclusiveResort);
			
	}
	
	
	
	
	
}