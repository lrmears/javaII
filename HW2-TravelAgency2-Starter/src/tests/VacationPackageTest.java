// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.
package tests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import triptypes.Cruise;
import triptypes.RoadTrip;
import triptypes.VacationPackage;

public class VacationPackageTest
{
	/**
	 * .
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	@Test
	public void VacationPackageSetNameTest()
	{
		String[] s = {"Chicago", "Miami", "Omaha"};
		VacationPackage a = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 3);
		
		assertEquals(((VacationPackage) a).getName(),"Jacob");
		
		VacationPackage b = new RoadTrip(null, 3, s, 2.45, 600, 2, 3);
		
		assertEquals(((VacationPackage) b).getName(),"PACKAGE NAME TBD");
		
		VacationPackage c = new RoadTrip("", 3, s, 2.45, 600, 2, 3);
		
		assertEquals(((VacationPackage) c).getName(),"PACKAGE NAME TBD");
	}

	
	@Test
	public void VacationPackageSetLenghtTest()
	{
		String[] s = {"Chicago", "Miami", "Omaha"};
		
		VacationPackage a = new RoadTrip("Jacob", -1, s, 2.45, 600, 2, 3);
		
		assertEquals(((VacationPackage) a).getNumDays(), 1);
		
	}

	@Test
	public void VacationPackageGetAmountDueTest()
	{
		
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		
		assertEquals(((VacationPackage) a).getAmountDue(), 3000, DOUBLE_TOLERANCE);
	
	}
	
	
	
	
	
	
	
}
