// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package reports;

/**
 * An Exception to be thrown if a requested year is not present in the data set.
 * The "serialVersionUID" warning can be suppressed.
 *
 * @author lmears, jacobsand
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
