// COURSE: CSCI1620
// TERM: SPRING 2020
// 
// NAME: Name
// RESOURCES: No outside resources were used in the creation of this enum.

package reports;

/**
 * An Exception to be thrown if a requested year is not present in the data set.
 * The "serialVersionUID" warning can be suppressed.
 * @author YOUR NAME
 *
 */
@SuppressWarnings("serial")
public class YearNotFoundException extends RuntimeException
{
	/**
	 * Sets the message of the Exception to "Requested year not in file".
	 */
	public YearNotFoundException()
	{
		
	}
}
