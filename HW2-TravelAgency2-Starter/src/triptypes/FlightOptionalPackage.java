// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package triptypes;
import java.util.ArrayList;

/**
 * This class encapsulates information about travel packages that can include optional flight arrangements.
 * Trips that have this format price flight information as an additional charge to a base package price
 * captured in a concrete subclass of FlightOptionalPackage.
 * @author lmears, jsand
 */
public abstract class FlightOptionalPackage extends VacationPackage
{
	/**
	 * Maximum number of flights allowed.
	 */
	public static final int FLIGHT_MAX = 12;
	/**
	 * Counts flight legs.
	 */
	private int count = 0;
	/**
	 * Array list to store flight legs.
	 */
	private ArrayList<Flight> leg = new ArrayList<Flight>(FLIGHT_MAX);
	
	/**
	 * Initializes details for a newly created FlightOptionalPackage. Upon creation,
	 * this package will contain no flight bookings. However, flight legs can be added at a later point.
	 * @param name - The promotional name of this package. 
	 * @param numDays - The number of days this travel package covers.
	 */
	public FlightOptionalPackage(String name, int numDays)
	{
		super(name, numDays);
	}
	
	/**
	 * Adds a single one-way flight to this package. Round trips and layovers are handled by multiple
	 * calls to addFlightLeg with one call for each flight. Flights must be added in chronological order,
	 * with the soonest flight added first. A maximum of up to 12 flights can be stored within a
	 * FlightOptionalPackage.
	 * @param details - A valid flight object to append to this itinerary. Invalid values (ie, null) or
	 * flights in excess of the 12 maximum will be ignored and will not impact this FlightOptionalPackage object.
	 */
	public void addFlightLeg(Flight details)
	{
		if (count < FLIGHT_MAX && details != null)
		{
			leg.add(details);
			count++;
		}
	}
	
	/**
	 * A predicate method for identifying whether a concrete object has at least one flight attached to it.
	 * @return true when at least one flight has been added, false otherwise.
	 */
	public boolean hasFlights()
	{
		boolean result = false;
		for (int i = 0; i < leg.size(); i++)
		{
			if (leg.get(i) != null)
			{
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Retrieves the current itinerary for this travel package. Flights are positioned
	 * in the returned array in the order in which they were added to this FlightOptionalPackage.
	 * @return The current itinerary array of Flight objects. null when no flights have been added yet.
	 */
	public Flight[] getFlightItinerary()
	{
		if (this.hasFlights())
		{
			Flight[] copy = leg.toArray(new Flight[FLIGHT_MAX]);
			return copy;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * The total cost of all legs in this FlightOptionalPackage.
	 * @return The sum of all individual flight costs in this package.
	 */
	public double getFlightCosts()
	{
		double costs = 0;
		for (int i = 0; i < leg.size(); i++)
		{
			costs += (leg.get(i)).getPrice();
		}
		return costs;
	}
	
	/**
	 * Retrieves a formatted string summary of this travel package. This string will be formatted exactly as
	 * prescribed by the TravelPackage class, with a postfix indicating whether flight information is
	 * included or not. For example, the strings below show two versions of a trip for each possible state.
	 * $1234.56 Spring Break at the Beach (Flight Included)
	 * $1234.56 Spring Break at the Beach (Flight Not Included)
	 * @return The formatted string summary.
	 */
	@Override
	public String toString()
	{
		String outputString;
		if (this.hasFlights())
		{
			outputString = super.toString() + " (Flight Included)";
		}
		else
		{
			outputString = super.toString() + " (Flight Not Included)";
		}
		return outputString;
	}

}
