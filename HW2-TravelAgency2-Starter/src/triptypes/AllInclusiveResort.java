// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package triptypes;

/**
 * This class encapsulates details related to an all-inclusive resort vacation package. Flight
 * information to/from the resort location can be added an additional price. Once at the resort,
 * all-inclusive packages are billed using a flat fee, regardless of the number of included amenities.
 * @author lmears, jsand
 */
public class AllInclusiveResort extends FlightOptionalPackage
{
	/**
	 * The name of the resort.
	 */
	private String resortName;
	/**
	 * The number of guests allowed per room at the included price.
	 */
	private int numGuestsPerRoom;
	/**
	 * The price of the stay per night.
	 */
	private double priceEachNight;
	/**
	 * A list of amenities available for free at the resort.
	 */
	private String[] amenities;

	/**
	 * Creates a new AllInclusiveResort package.
	 * @param name - The promotional name for this package.
	 * @param numDays - The number of days included in this vacation package.
	 * @param resort - The name of the resort.
	 * @param guestsPerRoom - The number of guests allowed per room at the included price.
	 * @param pricePerNight - The price of the stay per night.
	 * @param amenitiesList - A list of amenities available for free at the resort.
	 */
	public AllInclusiveResort(String name, int numDays, String resort, int guestsPerRoom, double pricePerNight,
			String[] amenitiesList)
	{
		super(name, numDays);
		this.resortName = resort;
		this.numGuestsPerRoom = guestsPerRoom;
		this.priceEachNight = pricePerNight;
		this.amenities = amenitiesList;
	}
	
	/**
	 * Retrieves a single String containing all of the available amenities at the resort.
	 * Individual amenities should be separated by a single comma and space character,
	 * with no such separator at the end of the string.
	 * @return The amenities list.
	 */
	public String getAmenities()
	{
		String outputString = "";
		// Loops through the array
		for (String amenity : amenities)
		{
			outputString += amenity;
			// Checks if item is not the last element in the array
			if (amenity != amenities[amenities.length - 1])
			{
				outputString += ", ";
			}
		}
		return outputString;
	}
	
	/**
	 * Retrieves the number of guests allowed per room at the specified rate.
	 * @return The number of guests per room.
	 */
	public int getGuestsPerRoom()
	{
		return this.numGuestsPerRoom;
	}
	
	/**
	 * The full price for this all-inclusive package, including any optional flight pricing.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return 0.0;
	}
	
	/**
	 * The required deposit amount to be made at the time of booking. All up front flight-related
	 * costs and 50% of the total lodging costs for this trip must be paid as a deposit.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		return 0.0;
	}
	
	/**
	 * A formatted summary string with details about this all-inclusive resort package. The string
	 * will contain information as described by FlightOptionalPackage followed by details about the
	 * resort and the number of people included at the specified price. The second line should be
	 * prefixed with 11 blank spaces for alignment below the trip name.
	 * @return The formatted string summary.
	 */
	@Override
	public String toString()
	{
		return "";
	}
	
	/**
	 * Retrieves the sub-total for lodging associated with this all inclusive resort stay based on the
	 * number of nights in the package and the base price.
	 * @return The lodging subtotal in US Dollars.
	 */
	public double getLodgingCost()
	{
		return 0.0;
	}
}
