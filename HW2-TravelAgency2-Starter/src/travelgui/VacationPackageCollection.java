// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package travelgui;

import triptypes.VacationPackage;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;

/**
 * This class serves as a collection to store, filter, and explore VacationPackages within the trip
 * search user interface. Up to 25 VacationPackages can be stored in a single collection.
 * @author lmears, jacobsand
 */
public class VacationPackageCollection
{
	/**
	 * Maximum number of vacation packages allowed.
	 */
	private static final int MAX_PACK = 25;
	/**
	 * Maximum number of flights allowed.
	 */
	private static final int MAX_FLIGHTS = 12;
	/**
	 * Stores the vacation array.
	 */
	private VacationPackage[] vacation;
	/**
	 * Number of trips.
	 */
	private int trips;
	
	/**
	 * Creates a new empty VacationPackageCollection.
	 */
	public VacationPackageCollection()
	{
		vacation = new VacationPackage[MAX_PACK];
		this.trips = 0;
	}
	
	/**
	 * Retrieves the number of trip packages that have been added to this collection for purchase.
	 * @return The total number of available packages.
	 */
	public int getNumTrips()
	{
		return this.trips;
	}
	
	/**
	 * Retrieves an array of all available packages from the collection. Valid packages are guaranteed
	 * to be stored contiguously in the left most array cells. Any empty cells will appear to the right
	 * of the last valid VacationPackage.
	 * Unless a sort has occurred, packages will appear in the order in which they were added.
	 * @return The list of available packages, or null if no packages exist.
	 */
	public VacationPackage[] getAllVacations()
	{
		return vacation;
	}
	
	/**
	 * Adds a single trip package to the collection at the next available position. If adding this
	 * trip would result in more than 25 total packages, it will not be added to the collection.
	 * @param trip - The trip to add to the collection.
	 */
	public void addVacation(VacationPackage trip)
	{
		for (int i = 0; i < vacation.length; i++)
		{
			if (vacation[i] == null)
			{
				vacation[i] = trip;
				this.trips++;
				break;
			}
		}
	}
	
	/**
	 * Retrieves a filtered subcollection of trips corresponding to a specific subtype. Should no
	 * trips of a specified type be present in this VacationPackageCollection an empty collection
	 * containing zero packages will be returned.
	 * @param selection - An integer signaling what type of packages to extract. 1 represents RoadTrips,
	 * 2 represents Cruises, and 3 represents All-Inclusive Resort packages.
	 * @return The filtered subcollection of packages, or an empty collection if no matching
	 * packages exist in this collection.
	 */
	public VacationPackageCollection filterVacationsFor(int selection)
	{

		VacationPackageCollection filter = new VacationPackageCollection();
		
		if (selection == 1)
		{
			for (int i = 0; i < vacation.length; i++)
			{
				if (vacation[i] instanceof triptypes.RoadTrip)
				{
					filter.addVacation(vacation[i]);
				}
			}
		}
		
		else if (selection == 2) 
		{
			for (int i = 0; i < vacation.length; i++)
			{
				if (vacation[i] instanceof triptypes.Cruise)
				{
					filter.addVacation(vacation[i]);
				}
			}
		}
		
		else if (selection == 3)
		{
			for (int i = 0; i < vacation.length; i++)
			{
				if (vacation[i] instanceof triptypes.AllInclusiveResort)
				{
					filter.addVacation(vacation[i]);
				}
			}
		}
		
		return filter;	
	}
	
	/**
	 * Produces a summary of flight information inside a VacationPackage for detail display elsewhere.
	 * In addition to properly extracting flight details when the given index corresponds to a
	 * FlightOptionalPackage with one or more flight legs, this method will also dectect various
	 * error conditions. In erroneous situations, one of the following strings will be produced:
	 * ERROR: Index is out of range!
	 * ERROR: No flights are allowed for this type of trip!
	 * ERROR: The selected trip has no flight information.
	 * Each of these errors corresponds to invalid range input, packages for which flights cannot be
	 * added in the first place, and packages which potentially could (but do not yet) have flight data.
	 * @param index - The index position in the collection from which to extract flight information.
	 * @return The formatted flight details, with one Flight per line and each Flight displayed as
	 * detailed in Flight.toString.
	 */
	public String getFlightDetails(int index)
	{
		String summary = ""; 
		
		if (index < 0 || index >= MAX_FLIGHTS)
		{
			summary = "ERROR: Index is out of range!";
		}
		
		else if (vacation[index] instanceof triptypes.RoadTrip)
		{
			summary = "ERROR: No flights are allowed for this type of trip!";
		}
		
		else if (!((FlightOptionalPackage) vacation[index]).hasFlights())
		{
			summary = "ERROR: The selected trip has no flight information.";
		}
		
		else
		{
			
			Flight[] a = new Flight[MAX_FLIGHTS];
			
			a = ((FlightOptionalPackage) vacation[index]).getFlightItinerary();

			
			for (int i = 0; i < MAX_FLIGHTS; i++)
			{
				if (a[i] != null)  
				{
					summary += a[i].toString() + "\n";
				}
				
			}
			
		}
	
		return summary;
	}
	
	/**
	 * Provides 0-based indexed access to the VacationPackageCollection.
	 * @param index - The index position whose VacationPackage should be returned.
	 * @return The selected VacationPackage when index is valid. The method will return null otherwise.
	 */
	public VacationPackage getItemAt(int index)
	{
		if (index >= 0)
		{
			return vacation[index];
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Produces a stable sort of the contents of this VacationPackageCollection, with the sort order
	 * determined by an externally specified criteria. When byPrice is true, the method will sort
	 * all available packages in ascending order by total package price. When false, the method sorts
	 * packages in standard lexicographically ascending order by package name
	 * (see, https://en.wikipedia.org/wiki/Lexicographical_order).
	 * @param byPrice - A flag which sets the sort criteria as described above.
	 */
	public void sortCollection(boolean byPrice)
	{
		if (byPrice)
		{
			for (int i = 0; i < MAX_PACK - 1; i++)
			{
				for (int r = 0; r < MAX_PACK - 1; r++)
				{	
					if (vacation[r + 1] != null
							&& vacation[r].getPrice() > vacation[r + 1].getPrice())
					{
						
						VacationPackage temp = (VacationPackage) vacation[r];
						vacation[r] = vacation[r + 1];
						vacation[r + 1] = temp;
					}
				}
			}
		}
		else
		{
			for (int f = 0; f < MAX_PACK - 1; f++)
			{
				for (int g = 0; g < MAX_PACK - 1; g++)
				{
					
					if (vacation[g + 1] != null
							&& ((vacation[g].getName()).compareTo(
									vacation[g + 1].getName())) > 0)
					{
						VacationPackage temp1 = vacation[g];
						vacation[g] = vacation[g + 1];
						vacation[g + 1] = temp1;
					}
				}
			}
		}
	}
}
