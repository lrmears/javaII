// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package tests;

import triptypes.*;

/**
 * Use this class to test methods.
 * @author lmears, jsand
 */
public class TestClass 
{
	public static void main(String[] args)
	{
		// Testing for AllInclusiveResort
		String[] amen = {"One", "Two", "Three"};
		AllInclusiveResort test = new AllInclusiveResort("name", 5, "resort", 3, 55.75, amen);
		System.out.println(test.getAmenities());
		
		// Testing for RoadTrip
		String[] stops = {"omaha", "iowa", "hawaii"};
		// RoadTrip(name, numDays, stops, fuelCost, miles, maxPersons, hotelStars)
		RoadTrip road = new RoadTrip("Road Trip", 3, stops, 1.7, 1700, 5, 5);
		System.out.println(road.getFuelPrice());
		System.out.println(road.getStops());
		System.out.println(road.toString());
		System.out.println(road.getLodgingCost());
		
	}
}
