// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package triptypes;
import java.util.Calendar;

/**
 * This class represents a cruise package within the travel agency. It stores required information
 * about the cruise ship, including departure and arrival times. It allows for optional off-ship excursion
 * packages to be added to a trip for an additional price.
 * @author lmears, jsand
 */
public class Cruise extends FlightOptionalPackage
{

	/**
	 * Creates a new Cruise trip with specified values for all data except optional excursions.
	 * @param name - The promotional name of the travel package.
	 * @param numDays - The number of days for this travel package.
	 * @param vesselName - The ship name for this Cruise.
	 * @param portCity - The departure port for this Cruise.
	 * @param departs - The time and date of departure from the port.
	 * @param returns - The time and date of return to the port.
	 * @param basePrice - The base price for the cheapest tier cabin (interior) on the ship. Cabin upgrades
	 * can be accommodated through a subsequent setter call.
	 */
	public Cruise(String name, int numDays, String vesselName, String portCity, Calendar departs, Calendar returns,
			double basePrice)
	{
		super(name, numDays);
	}
	
	/**
	 * Adds a named excursion to this Cruise. Excursions may or may not have an additional charge associated.
	 * A maximum of 10 excursions can be added.
	 * @param excursion - The name of the excursion to add to this package. Empty excursion values are
	 * invalid and should not result in a change to the Cruise package configuration. 
	 * @param price - The price of the excursion. Prices must be >= 0, with any negative values being
	 * treated as equivalent to 0.
	 */
	public void addExcursion(String excursion, double price)
	{
		
	}
	
	/**
	 * Retrieves an array containing all of the excursions which have been added to this Cruise, in the
	 * order in which they were added.
	 * @return The list of excursions.
	 */
	public String[] getExcursion()
	{
		return new String[0];
	}
	
	/**
	 * Updates the cabin configuration for this Cruise. This method can be used to upgrade a cruise
	 * from the base price corresponding to the cheapest cabin (an interior cabin without any ocean view).
	 * @param cabin - A valid alternate cabin level for this package.
	 */
	public void setCabinType(CabinType cabin)
	{
		
	}
	
	/**
	 * Retrieves the cabin level currently associated with this Cruise package.
	 * @return The current cabin level.
	 */
	public CabinType getCabinType()
	{
		return CabinType.BALCONY;
	}
	
	/**
	 * Retrieves the home port of the cruise ship for this package.
	 * @return The city from which this Cruise departs.
	 */
	public String getHomePort()
	{
		return "";
	}
	
	/**
	 * Retrieves the date and time of departure for this Cruise.
	 * @return The departure time at the port.
	 */
	public Calendar getDepartureDate()
	{
		return null;
	}
	
	/**
	 * Retrieves the date and time of arrival for this Cruise.
	 * @return The arrival time at the port.
	 */
	public Calendar getReturnDate()
	{
		return null;
	}
	
	/**
	 * Retrieves the name of ship sailing for this Cruise.
	 * @return The ship name.
	 */
	public String getVesselName()
	{
		return "";
	}
	
	/**
	 * Retrieves the total cost for all added excursions on this Cruise.
	 * @return The excursions total in US Dollars.
	 */
	public double getExcursionCosts()
	{
		return 0.0;
	}
	
	/**
	 * Retrieves the number of excursions which have been added to this Cruise package.
	 * @return The number of excursions.
	 */
	public int getNumExcursions()
	{
		return 0;
	}
	
	/**
	 * Retrieves the full price of this Cruise package, including pre-cruise flight
	 * arrangements (as applicable), full lodging costs, and any additional excursion costs.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return 0.0;
	}
	
	/**
	 * Retrieves the deposit amount required upfront for this Cruise. Cruise packages require
	 * that all applicable flight costs and 50% of expected lodging costs are paid at the time of
	 * booking. Optional excursion costs are not included in the deposit amount, but must be paid
	 * prior to departure.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		return 0.0;
	}
	
	/**
	 * Retrieves the lodging charge for this Cruise package, calculated from the base price scaled
	 * based on the cabin level according to the following fee schedule:.
	 * Interior Room:     100% of base price
	 * Ocean View Room:   150% of base price
	 * Balcony Room:      300% of base price
	 * Luxury Suite:      500% of base price
	 * @return The lodging sub-total in US Dollars.
	 */
	public double getLodgingCost()
	{
		return 0.0;
	}
	
	/**
	 * Retrieves a formatted string summarizing this Cruise package. The required format for this string
	 * includes information as described by FlightOptionalPackage followed by cruise details on the
	 * next line. The second line should be prefixed with 11 blank spaces for alignment below the trip name.
	 * An example of this format is shown here:
	 * $ 2499.99  Bermuda Triangle...and Maybe Back (Flight Not Included)
	 * 			  Cruising from Miami on the Caribbean Princess
	 * If optional excursions have been added, a parenthetical suffix will be added indicating
	 * how many excursions are included:
	 * $ 2499.99  Bermuda Triangle...and Maybe Back (Flight Not Included)
	 * 			  Cruising from Miami on the Caribbean Princess (includes 4 excursions)
	 * @return The formatted string summary.
	 */
	@Override
	public String toString()
	{
		return "";
	}
}
