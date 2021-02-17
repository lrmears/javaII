// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package tests;

import triptypes.*;

public class TestClass 
{
	public static void main(String[] args)
	{
		String[] amen = {"One", "Two", "Three"};
		AllInclusiveResort test = new AllInclusiveResort("name", 5, "resort", 3, 55.75, amen);
		System.out.println(test.getAmenities());
		
	}
}
