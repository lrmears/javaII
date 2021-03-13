// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package scraper.utils;

/**
 * This class provides access to details about a single HTML element. Access to tag name,
 * attribute details, and the inner HTML contents are provided through the methods.
 * @author lmears, jacobsand
 */
public class Element
{
	/**
	 * Retrieves the value of a specified attribute from this element. URLs that are part of href
	 * or src attributes will always be returned in absolute path terms.
	 * @param attributeName - The attribute of interest, case insensitive. 
	 * @return The associated value in the HTML tag for this element. If no valid value exists for the
	 * attribute specified, the empty string will be returned.
	 */
	public String getAttributeValue(String attributeName)
	{
		return "";
	}
	
	/**
	 * Retrieves the full HTML contained inside of an element.
	 * @return The inner HTML contents.
	 */
	public String getInnerHTML()
	{
		return "";
	}
	
	
}
