// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.
package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;

import java.util.Calendar;
import triptypes.VacationPackage;
import triptypes.CabinType;
import triptypes.Cruise;


public class CruiseTest 
{

	/**
	 * .
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	/**
	 * .
	 */
	@Test
	public void cruiseConstructorTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
	
		assertEquals("Jacob", a.getName());
		assertEquals(7, a.getNumDays());
		assertEquals("Ship", ((Cruise) a).getVesselName());
		assertEquals("Long Beach", ((Cruise) a).getHomePort());
		assertEquals(date1, ((Cruise) a).getDepartureDate());
		assertEquals(date2, ((Cruise) a).getReturnDate());
		assertEquals(6000, ((Cruise) a).getLodgingCost(), DOUBLE_TOLERANCE);
	
	}
	
	/**
	 * .
	 */
	@Test
	public void cruiseAddExcursionTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
	
		((Cruise) a).addExcursion("Brazil", 1000);
		
		assertEquals(1000, ((Cruise) a).getExcursionCosts(), DOUBLE_TOLERANCE);
		
		String[] testArray = ((Cruise) a).getExcursions();
		
		assertEquals("Brazil", testArray[0]);
	}
	
	/**
	 * .
	 */
	@Test
	public void cruiseAddExcursionEmptyTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
	
		((Cruise) a).addExcursion("", 1000);
		
		assertEquals(0, ((Cruise) a).getExcursionCosts(), DOUBLE_TOLERANCE);
		
		String[] testArray = ((Cruise) a).getExcursions();
		
		assertEquals(testArray[0], null);
	}
	
	/**
	 * .
	 */
	@Test
	public void cruiseAddExcursionNegativeTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
	
		((Cruise) a).addExcursion("Brazil", -1);
		
		assertEquals(0, ((Cruise) a).getExcursionCosts(), DOUBLE_TOLERANCE);
		
		String[] testArray = ((Cruise) a).getExcursions();
		
		assertEquals(testArray[0], "Brazil");
	}
	
	
	
	
	
	/**
	 * .
	 */
	@Test
	public void cruiseAddExcursionFullTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
	
		((Cruise) a).addExcursion("Spain", 1000);
		((Cruise) a).addExcursion("Brazil", 1000);
		((Cruise) a).addExcursion("Spain", 1000);
		((Cruise) a).addExcursion("Brazil", 1000);
		((Cruise) a).addExcursion("Spain", 1000);
		((Cruise) a).addExcursion("Brazil", 1000);
		((Cruise) a).addExcursion("Spain", 1000);
		((Cruise) a).addExcursion("Brazil", 1000);
		((Cruise) a).addExcursion("Spain", 1000);
		((Cruise) a).addExcursion("Brazil", 1000);
		((Cruise) a).addExcursion("Spain", 1000);
		
		assertEquals(10, ((Cruise) a).getNumExcursions());
		
		assertEquals(10000, ((Cruise) a).getExcursionCosts(), DOUBLE_TOLERANCE);
		
		String[] testArray = ((Cruise) a).getExcursions();
		
		
		assertEquals(testArray[0], "Spain");
		assertEquals(testArray[1], "Brazil");
		assertEquals(testArray[2], "Spain");
		assertEquals(testArray[3], "Brazil");
		assertEquals(testArray[4], "Spain");
		assertEquals(testArray[5], "Brazil");
		assertEquals(testArray[6], "Spain");
		assertEquals(testArray[7], "Brazil");
		assertEquals(testArray[8], "Spain");
		assertEquals(testArray[9], "Brazil");
		//assertEquals(testArray[10], null);
		
		assertEquals(10, testArray.length);
		
		
			
	}
	
	@Test
	public void cruiseSetCabinTypeTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		((Cruise) a).setCabinType(CabinType.INTERIOR);
		
		assertEquals(CabinType.INTERIOR, ((Cruise) a).getCabinType());
		
		((Cruise) a).setCabinType(CabinType.OCEAN_VIEW);
		
		assertEquals(CabinType.OCEAN_VIEW, ((Cruise) a).getCabinType());
		
		((Cruise) a).setCabinType(CabinType.BALCONY);
		
		assertEquals(CabinType.BALCONY, ((Cruise) a).getCabinType());
		
		((Cruise) a).setCabinType(CabinType.SUITE);
		
		assertEquals(CabinType.SUITE, ((Cruise) a).getCabinType());
	
	}
	
	/**
	 * .
	 */
	
	@Test
	public void cruiseGetPriceTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		((Cruise) a).addExcursion("Spain", 1000);
		((Cruise) a).addExcursion("Brazil", 1000);
		
		assertEquals(8000, ((Cruise) a).getPrice(), DOUBLE_TOLERANCE);
		
	}
	
	/**
	 * .
	 */
	@Test
	public void cruiseGetDepositTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		((Cruise) a).addExcursion("Spain", 1000);
		((Cruise) a).addExcursion("Brazil", 1000);
		
		assertEquals(3000, ((Cruise) a).getDepositAmount(), DOUBLE_TOLERANCE);
		
	}
	
	/**
	 * .
	 */
	@Test
	public void cruiseGetLodgingCostTest()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		((Cruise) a).setCabinType(CabinType.INTERIOR);
		
		assertEquals(6000, ((Cruise) a).getLodgingCost(), DOUBLE_TOLERANCE);
		
		((Cruise) a).setCabinType(CabinType.OCEAN_VIEW);
		
		assertEquals(9000, ((Cruise) a).getLodgingCost(), DOUBLE_TOLERANCE);
		
		((Cruise) a).setCabinType(CabinType.BALCONY);
		
		assertEquals(18000, ((Cruise) a).getLodgingCost(), DOUBLE_TOLERANCE);
		
		((Cruise) a).setCabinType(CabinType.SUITE);
		
		assertEquals(30000, ((Cruise) a).getLodgingCost(), DOUBLE_TOLERANCE);
			
	}
	
	/**
	 * .
	 */
	@Test
	public void cruiseToStringNoExcursions()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		assertEquals("$ 6000.00  Jacob (Flight Not Included)\n"
				+ "           Cruising from Long Beach on the Ship", ((Cruise) a).toString());
	}
	
	/**
	 * .
	 */
	@Test
	public void cruiseToStringExcursions()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		((Cruise) a).addExcursion("Spain", 1000);
		
		assertEquals("$ 6000.00  Jacob (Flight Not Included)\n"
				+ "           Cruising from Long Beach on the Ship", ((Cruise) a).toString());
	}
	
	
	/**
	 * .
	 */
	@Test
	public void cruiseInitialNumExcursions()
	{
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 02, 15, 15, 25);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2021, 02, 15, 18, 01);
		
		VacationPackage a = new Cruise("Jacob", 7, "Ship", "Long Beach", date1, date2, 6000);
		
		assertEquals(0, ((Cruise)a).getNumExcursions());
		
		((Cruise) a).addExcursion("Spain", 1000);
		
		assertEquals(1, ((Cruise)a).getNumExcursions());
		
		
	}

}
