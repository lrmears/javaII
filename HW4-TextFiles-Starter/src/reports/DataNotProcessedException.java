// COURSE: CSCI1620
// TERM: SPRING 2020
// 
// NAME: Name
// RESOURCES: No outside resources were used in the creation of this enum.

package reports;

/**
 * An Exception to be thrown if it is attempted to write a report that has not been processed.
 * The "serialVersionUID" warning can be suppressed.
 * @author YOUR NAME
 *
 */
@SuppressWarnings("serial")
public class DataNotProcessedException extends RuntimeException
{
	/**
	 * Sets the message of the Exception to "Data not processed, cannot write report".
	 */
	public DataNotProcessedException()
	{
		
	}

}
