// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package reports;

/**
 * An Exception to be thrown if it is attempted to write a report that has not been processed.
 * The "serialVersionUID" warning can be suppressed.
 *
 * @author lmears, jacobsand
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
