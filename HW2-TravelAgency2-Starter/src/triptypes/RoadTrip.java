// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package triptypes;

/**
 * This class represents a RoadTrip vacation that includes a rental car, overnight lodging, and fuel cost estimation.
 * @author lmears, jsand
 */
public class RoadTrip extends VacationPackage
{
	/**
	 * A list of destinations that will be visited along the way on this RoadTrip.
	 */
	private String[] stopsList;
	/**
	 * The estimated cost of fuel in US Dollars per Gallon based on current rates.
	 */
	private double fuelPrice;
	/**
	 * The total number of miles for this RoadTrip, assuming people follow the intended route.
	 */
	private int totalMiles;
	/**
	 * The number of people for whom this trip package will be budgeted.
	 */
	private int maxNumPersons;
	/**
	 * The quality level of the hotels used during the RoadTrip, ranging from 1..5
	 * stars, inclusive. Star values outside this range will be adjusted to the closest valid value.
	 */
	private int hotelRating;
	/**
	 * Default fuel price.
	 */
	private final double defaultFuelPrice = 2.5;
	/**
	 * Base room cost per night for lodging.
	 */
	private final double baseRoomCost = 32.5;
	
	/**
	 * Creates a newly initialized RoadTrip object using the parameter data.
	 * @param name - The promotional name to use for this RoadTrip in the travel agency system.
	 * @param numDays - The number of days required for this RoadTrip.
	 * @param stops - A list of destinations that will be visited along the way on this RoadTrip.
	 * @param fuelCost - The estimated cost of fuel in US Dollars per Gallon based on current rates.
	 * @param miles - The total number of miles for this RoadTrip, assuming people follow the intended route.
	 * @param maxPersons - The number of people for whom this trip package will be budgeted.
	 * @param hotelStars - The quality level of the hotels used during the RoadTrip, ranging from 1..5
	 * stars, inclusive. Star values outside this range will be adjusted to the closest valid value.
	 */
	public RoadTrip(String name, int numDays, String[] stops, double fuelCost, int miles, int maxPersons,
			int hotelStars)
	{
		super(name, numDays);
		this.stopsList = stops;
		this.fuelPrice = fuelCost;
		this.totalMiles = miles;
		this.maxNumPersons = maxPersons;
		this.hotelRating = hotelStars;
	}
	
	/**
	 * Retrieves the hotel quality level attached to this RoadTrip package.
	 * @return The number of stars for hotel stays.
	 */
	public int getHotelStars()
	{
		return this.hotelRating;
	}
	
	/**
	 * Provides the full price of this RoadTrip object. RoadTrip prices are computed based on the
	 * total rental car, lodging, and fuel estimated costs.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return 0.0;
	}
	
	/**
	 * Provides the required deposit amount for this RoadTrip object. The required deposit for a
	 * Road trip includes the full lodging cost plus the full rental car cost.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		return 0.0;
	}
	
	/**
	 * All RoadTrips must be fully paid in advance, with the exception of fuel costs. Fuel costs are
	 * paid to the gas station, and not the travel agent. Thus, the balance due on RoadTrips is always 0.
	 * @return The remaining balance to pay the travel agency.
	 */
	public double getAmountDue()
	{
		return 0.0;
	}
	
	/**
	 * Provides the total lodging cost for a RoadTrip object. Lodging is computed based on the length
	 * of the vacation, the quality of the hotel (in stars), the number of rooms needed for the party
	 * and a base charge of $35.20 per room per night. Lodging costs assume a maximum 2 person occupancy per room. 
	 * For example, a 5 day road trip for 4 people in 2 star hotels is costed as: $35.20 base x 2 star
	 * hotels x 4 nights x 2 rooms per night --> $563.20
	 * @return The lodging subtotal in US Dollars.
	 */
	public double getLodgingCost()
	{
		return baseRoomCost * this.getHotelStars() * (this.getNumDays() - 1) 
				* Math.ceil(this.getNumPersons() / 2.0);
	}
	
	/**
	 * Provides the total cost for the rental car based on the trip duration and the size of car needed.
	 * Rental cars are billed based on full days, with no partial day rentals allowed. Further, the
	 * travel agency uses a standard daily rental car charge based on the number of occupants riding along:
	 * $ 36.75   1-2 passengers
	 * $ 50.13   3-4 passengers
	 * $ 60.25   5-6 passengers
	 * $ 70.50   7-8 passengers
	 * $150.00   9+ passengers (since you'll need a bus)
	 * @return The total rental car cost for this trip.
	 */
	public double getCarCost()
	{
		return 0.0;
	}
	
	/**
	 * Retrieves the number of stops along the route for this RoadTrip.
	 * @return The number of intermediate destinations.
	 */
	public int getNumStops()
	{
		return stopsList.length;
	}
	
	/**
	 * Updates the number of people to be used for budgeting this RoadTrip within the travel agency.
	 * @param maxPeople - The new number of people to use in calculations.
	 */
	public void setPersons(int maxPeople)
	{
		maxNumPersons = maxPeople;
	}
	
	/**
	 * Retrieves the number of people included for budget calculations by this RoadTrip.
	 * @return The number of persons.
	 */
	public int getNumPersons()
	{
		return maxNumPersons;
	}
	
	/**
	 * Updates the cost of fuel in US dollars per gallon. This value is used for projecting out costs
	 * for this RoadTrip. Prices must be positive values, and a default assumption of $2.50 per gallon
	 * will be used if an invalid price is specified.
	 * @param pricePerGallon - The new price to use for cost projections.
	 */
	public void setFuelPrice(double pricePerGallon)
	{
		if (pricePerGallon > 0)
		{
			fuelPrice = pricePerGallon;
		}
		else
		{
			fuelPrice = defaultFuelPrice;
		}
	}
	
	/**
	 * Retrieves the current fuel price used for cost projections.
	 * @return The fuel price in US dollars per gallon.
	 */
	public double getFuelPrice()
	{
		return fuelPrice;
	}
	
	/**
	 * Provides a projection of the total fuel cost for this trip based on the total number of miles to
	 * be traveled, the fuel efficiency of the rental car, and the cost of fuel. Standard rental cars
	 * used have decreasing fuel efficiency as the size gets bigger. Thus, efficiency is a function of
	 * passenger count. We assume the following projections:
	 * 45mpg   1-2 passengers
	 * 32mpg   3-4 passengers
	 * 28mpg   5-6 passengers
	 * 22mpg   7-8 passengers
	 * 15mpg   9+ passengers (buses aren't very efficient)
	 * @return The projected fuel cost in US dollars.
	 */
	public double getEstimatedFuelCost()
	{
		double price = 0;
		if (this.getNumPersons() >= 1 && this.getNumPersons() <= 2)
		{
			price = (totalMiles / 45.0) * this.getFuelPrice();
		}
		else if (this.getNumPersons() >= 3 && this.getNumPersons() <= 4)
		{
			price = (totalMiles / 32.0) * this.getFuelPrice();
		}
		else if (this.getNumPersons() >= 5 && this.getNumPersons() <= 6)
		{
			price = (totalMiles / 28.0) * this.getFuelPrice();
		}
		else if (this.getNumPersons() >= 7 && this.getNumPersons() <= 8)
		{
			price = (totalMiles / 22.0) * this.getFuelPrice();
		}
		else if (this.getNumPersons() >= 9)
		{
			price = (totalMiles / 15.0) * this.getFuelPrice();
		}
		return price;
	}
	
	/**
	 * Retrieves the list of stops on this RoadTip as a single string with values separated
	 * by a comma and a single space. The last stop has no punctuation after it.
	 * @return The list of stops.
	 */
	public String getStops()
	{
		String outputString = "";
		// Loops through the array
		for (String stop : stopsList)
		{
			outputString += stop;
			// Checks if item is not the last element in the array
			if (stop != stopsList[stopsList.length - 1])
			{
				outputString += ", "; 
			}
		}
		return outputString;
	}
	
	/**
	 * Provides a string summary of this RoadTrip. Promotional details and trip duration are provided
	 * as with all VacationPackages, followed by a summary message about the stops to be made on the
	 * following line with each stop separated by a comma. The second line should be prefixed with 11
	 * blank spaces for alignment below the trip name. For example:
	 * $  150.99  Rustic Backpacking at Mt. Rushmore
	 * 			  A road trip with stops at Carhenge, Chimney Rock, The Corn Palace, Mt. Rushmore
	 * @return The formatted string summary.
	 */
	@Override
	public String toString()
	{
		return String.format("$%8.2f  %s\n%36s %s",
				this.getPrice(), this.getName(), "A road trip with stops at", this.getStops());
	}
}
