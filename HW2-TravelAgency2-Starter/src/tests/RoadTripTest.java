// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import triptypes.RoadTrip;
/**
 * Test for RoasTrip class.
 * @author lmears jacobsand
 *
 */
public class RoadTripTest 
{
	/**
	 * Tolerance.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	/**
	 * .
	 */
	private static final double FUEL_PRICE = 2.45;
	/**
	 * .
	 */
	private static final int DISTANCE = 600;
	
	//private static final double DISTANCE
	
	/**
	 * Double.
	 */
	private double p;
	/**
	 * Stops.
	 */
	private String[] s = {"Chicago", "Miami", "Omaha"};
	
	
	
	
	/**
	 * Constructor test.
	 */
	@Test
	public void roadTripConstructorTest() 
	{
		
		RoadTrip a = new RoadTrip("Jacob", 7, s, FUEL_PRICE, DISTANCE, 6, 3);
		a.setFuelPrice(FUEL_PRICE);
		
		assertEquals("Jacob", a.getName());
		assertEquals(7, a.getNumDays());
		assertEquals("Chicago, Miami, Omaha", a.getStops());
		assertEquals(2.45, a.getFuelPrice(),DOUBLE_TOLERANCE );
		assertEquals(600, a.getMiles());
		assertEquals(6, a.getNumPersons());
		assertEquals(3, a.getHotelStars());
		
	}
	
	/**
	 * Testing for price of one person and estimated fuel cost.
	 */
	@Test
	public void getPriceTest1Persons()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 1, 3);
		p = a.getCarCost()+a.getLodgingCost()+a.getEstimatedFuelCost();
		assertEquals(p, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for price of two person.
	 */
	@Test
	public void getPriceTest2Persons()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 2, 3);
		p = a.getCarCost() + a.getLodgingCost() + a.getEstimatedFuelCost();
		assertEquals(p, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for price of 3 person.
	 */
	@Test
	public void getPriceTest3Persons()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 3, 3);
		p = a.getCarCost() + a.getLodgingCost() + a.getEstimatedFuelCost();
		assertEquals(p, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for price of 4 person.
	 */
	@Test
	public void getPriceTest4Persons()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 4, 3);
		p = a.getCarCost() + a.getLodgingCost() + a.getEstimatedFuelCost();
		assertEquals(p, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for price of 5 person.
	 */
	@Test
	public void getPriceTest5Persons()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 5, 3);
		p = a.getCarCost() + a.getLodgingCost() + a.getEstimatedFuelCost();
		assertEquals(p, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for price of 6 person.
	 */
	@Test
	public void getPriceTest6Persons()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 6, 3);
		p = a.getCarCost() + a.getLodgingCost() + a.getEstimatedFuelCost();
		assertEquals(p, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for price of 7 person.
	 */
	@Test
	public void getPriceTest7Persons()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 7, 3);
		p = a.getCarCost() + a.getLodgingCost() + a.getEstimatedFuelCost();
		assertEquals(p, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for price of 8 person.
	 */
	@Test
	public void getPriceTest8Persons()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 8, 3);
		p = a.getCarCost() + a.getLodgingCost() + a.getEstimatedFuelCost();
		assertEquals(p, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for price of more than 8 persons person.
	 */
	@Test
	public void getPriceTestMoreThan8()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 9, 3);
		p = a.getCarCost() + a.getLodgingCost() + a.getEstimatedFuelCost();
		assertEquals(p, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for a valid deposit amount.
	 */
	@Test
	public void getDepositAmountTestValid()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 9, 3);
		p = a.getLodgingCost() + a.getCarCost();
		assertEquals(p, a.getDepositAmount(), DOUBLE_TOLERANCE);
		
	}
	
	/**
	 * Testing for a valid lodging cost with even number of person.
	 */
	@Test
	public void getLodgingCostTestValidEven()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 8, 3);
		p = 35.20 * 3 * 3 * 4;
		assertEquals(p, a.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for a valid lodging cost with an odd number of person.
	 */
	@Test
	public void getLodgingCostTestValidOdd()
	{
		RoadTrip a = new RoadTrip("Jacob", 4, s, 2.45, 600, 9, 3);
		p = 35.20 * 3 * 3 * 5;
		assertEquals(p, a.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for a valid carCost.
	 */
	@Test
	public void getCarCostTest()
	{
		RoadTrip a = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 3);
		assertEquals(110.25, a.getCarCost(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for a valid amount due.
	 */
	@Test
	public void getAmountDueTestValid()
	{
		RoadTrip a = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 3);
		p = 211.2 + 110.25;
		assertEquals(0, a.getAmountDue(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Testing for number of stops.
	 */
	@Test
	public void getNumStopsTest()
	{
		RoadTrip a = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 3);
		assertEquals(s.length, a.getNumStops());
	}
	/**
	 * Testing to set for a valid and invalid fuel price.
	 */
	@Test
	public void setFuelPriceTest()
	{
		RoadTrip a = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 3);
		a.setFuelPrice(2.19);
		assertEquals( 2.19, a.getFuelPrice(), DOUBLE_TOLERANCE);
		a.setFuelPrice(-2.19);
		assertEquals( 2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
	}
	/**
	 * Testing to set for a person.
	 */
	@Test
	public void setPersonTest()
	{
		RoadTrip a = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 3);
		a.setPersons(2);
		assertEquals(2, a.getNumPersons());
	}
	
	/**
	 * Testing for number miles for the trip.
	 */
	@Test
	public void getMilesTest()
	{
		RoadTrip a = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 3);
		assertEquals(600, a.getMiles());
	}
	
	/**
	 * Testing for hotel starts.
	 */
	@Test
	public void getHotelStarsTest()
	{
		RoadTrip a = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 3);
		assertEquals(3, a.getHotelStars());
		
		RoadTrip b = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 7);
		assertEquals(5, b.getHotelStars());
		
		RoadTrip c = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 0);
		assertEquals(1, c.getHotelStars());
		
		RoadTrip d = new RoadTrip("Jacob", 3, s, 2.45, 600, 2, 5);
		assertEquals(5, d.getHotelStars());
	}
	
	@Test
	public void getEstimatedFuelCost()
	{
		RoadTrip a = new RoadTrip("Jacob", 3, s, 2.45, 600, 1, 3);
		
		System.out.println(a.getEstimatedFuelCost());
		
		double r = ((double) 600)/45;
		
		
		assertEquals(32.667, a.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
	}
	
	
	@Test
	public void toStringTest()
	{
		RoadTrip a = new RoadTrip("Jacob", 3, s, 2.45, 600, 1, 3);
		
		String b = a.toString();
		
		System.out.println(b);
		
		assertEquals(b, "$  354.12  Jacob"+"\n           A road trip with stops at Chicago, Miami, Omaha");
		
	}
	
	
}
