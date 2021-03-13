// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package scraper.utils;

/**
 * The Elements class represents a collection of HTML elements retrieved from a Document. It allows a
 * user to iterate through each Element and process them in a manner similar to Java's Scanner class.
 * @author lmears, jacobsand
 */
public class Elements
{
	/**
	 * A predicate method to indicate whether another item exists inside this collection.
	 * @return True if another item can be retrieved; false otherwise
	 */
	public boolean hasNextElement()
	{
		return true;
	}
	
	/**
	 * Retrieves the next unread Element from the collection of Elements.
	 * @return The next item in the collection if present. Null will be returned if no next item exists.
	 */
	public Element getNextElement()
	{
		return new Element();
	}
	
	/**
	 * Retrieves the total number of Element objects in this collection.
	 * @return The size of the collection. Could potentially be zero.
	 */
	public int size()
	{
		return 0;
	}
}
