// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package scraper.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jsoup.nodes.Element;

/**
 * The Elements class represents a collection of HTML elements retrieved from a Document. It allows a
 * user to iterate through each Element and process them in a manner similar to Java's Scanner class.
 * @author lmears, jacobsand
 */
public class Elements
{
	/**
	 * Variable for elements.
	 */
	private org.jsoup.select.Elements elems;
	/**
	 * Iterator object.
	 */
	private Iterator<Element> iter;
	
	protected Elements(org.jsoup.select.Elements elemsIn)
	{
		this.elems = elemsIn;
		this.iter = this.elems.iterator();
	}
	
	/**
	 * A predicate method to indicate whether another item exists inside this collection.
	 * @return True if another item can be retrieved; false otherwise
	 */
	public boolean hasNextElement()
	{
		return this.iter.hasNext();
	}
	
	/**
	 * Retrieves the next unread Element from the collection of Elements.
	 * @return The next item in the collection if present. Null will be returned if no next item exists.
	 */
	public Element getNextElement()
	{
		Element e;
		try
		{
			e = new Element((Element) this.itr.next());
		}
		catch (NoSuchElementException var3)
		{
			e = null;
		}
		return e;
	}
	
	/**
	 * Retrieves the total number of Element objects in this collection.
	 * @return The size of the collection. Could potentially be zero.
	 */
	public int size()
	{
		return this.elems.size();
	}
}
