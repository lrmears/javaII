// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package triptypes;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * This class represents a single flight within the travel agency system.
 * @author lmears, jsand
 */
public class Flight
{
	/**
	 * Different airline options.
	 */
	private String airlineOptions;	
	/**
	 * flightNumber is just the holder for different flight numbers.
	 */
	private int flightNumber;
	/**
	 * sourcePoint is the holder for the airport code.
	 */
	private String sourcePoint;
	/**
	 * endPoint is the holder for the flying to airport code.
	 */
	private String endPoint;
	/**
	 * departTime local holder for the departure time from the airport. 
	 */
	private Calendar departTime;
	/**
	 * arrivalTime is the local holder for the expected arrival time at the airport.
	 */
	private Calendar arrivalTime;
	/**
	 * costFlight is the local holder for the price.
	 */
	private double costFlight;
	/**
	 * Creates a new flight leg in the system.
	 * @param airline - The two letter airline code (e.g, "DL", "AA")
	 * @param flightNum - The unique flight number on a given day
	 * @param from - The three letter airport code for the departure airport (e.g, "OMA")
	 * @param to - The three letter airport code for the arrival airport (e.g., "CDG")
	 * @param leavesAt - The departure time
	 * @param arrives - The arrival time
	 * @param price - The price for this flight in US Dollars.
	 */
	public Flight(String airline, int flightNum, String from, String to, Calendar leavesAt, Calendar arrives,
			double price)
	{
		this.airlineOptions = airline;
		this.flightNumber = flightNum;
		this.sourcePoint = from;
		this.endPoint = to;
		this.departTime = leavesAt;
		this.arrivalTime = arrives;
		this.costFlight = price;
	}
	 
	/**
	 * Retrieves the price of this flight.
	 * @return The price in US Dollars.
	 */
	public double getPrice()
	{
		return costFlight;
	}
	
	/**
	 * Retrieves a formatted string summarizing this Flight. Strings will be formatted as: 
	 * XX#### Departs: AIR at HH:mm MM-dd-YYYY; Arrives POR at HH:mm MM-dd-YYYY
	 * Where XX is the two letter airline abbreviation and #### is the flight number, which may be
	 * 1-4 digits in length and is right aligned in a 4 character wide field. AIR and POR are the
	 * departure and arrival airport codes, respectively. The HH:mm MM-dd-YYYY values correspond to the
	 * departure and arrival time formats using a 24-hour clock. (see, e.g., java.util.SimpleDateFormat).
	 * For example:
	 * DL 123 Departs: OMA at 15:25 03-15-2019; Arrives ATL at 18:01 03-15-2019
	 */
	@Override
	public String toString()
	{
		SimpleDateFormat formatted = new SimpleDateFormat("HH:mm MM-dd-yyyy");
		return String.format("%s%4d Departs: ", this.airlineOptions, this.flightNumber, 
				"%s at %s; ", this.sourcePoint, formatted.format(this.departTime.getTime()),
				"Arrives %s at %s", this.endPoint, formatted.format(this.arrivalTime.getTime()));
	}
}
