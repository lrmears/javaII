// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package scraper.utils;

import java.util.Iterator;
import java.util.LinkedList;
import scraper.base.ImageEntry;

/**
 * This class provides a simple mechanism for tracking web scraping ImageEntry results. In addition to
 * adding items and retrieving the results as an array, it allows for ResultSet objects to be easily merged together.
 * @author lmears, jacobsand
 */
public class ResultSet
{
	/**
	 * Linked list that stores the result set.
	 */
	private LinkedList<ImageEntry> list = new LinkedList<ImageEntry>();

	/**
	 * Creates a new empty ResultSet object.
	 */
	public ResultSet()
	{
		
	}
	
	/**
	 * Adds the given ImageEntry to the end of this ResultSet. Addition of entries that would result
	 * in two equivalent ImageEntry objects (by comparison via the quals method) will be ignored.
	 * @param img - The latest item to add to this ResultSet.
	 */
	public void addResult(ImageEntry img)
	{
		if (!this.list.contains(img))
		{
			this.list.add(img);
		}
	}
	
	/**
	 * Merges this ResultSet with the one specified by other as a separate returned ResultSet. Calling
	 * this method does not modify the contents of the ResultSet on which it is invoked. The returned
	 * ResultSet will contain all items from this ResultSet followed by all items from other (similar to
	 * String concatenation).
	 * @param other - The ResultSet to merge with this one.
	 * @return The merged contents of both this and other.
	 */
	public ResultSet merge(ResultSet other)
	{
		ResultSet res = new ResultSet();
		res.list.addAll(this.list);
		if (other != null)
		{
			Iterator var4 = other.list.iterator();

			while (var4.hasNext())
			{
				ImageEntry ie = (ImageEntry) var4.next();
				res.addResult(ie);
			}
		}

		return res;
	}
	
	/**
	 * Retrieves all ImageEntry objects in this ResultSet as an array. ImageEntry objects will appear
	 * in the order in which they were added to this ResultSet and the size of the array will match the
	 * number of add operations which were performed on this results set.
	 * @return The contents of this ResultSet as an array. If this ResultSet is empty, null will be returned.
	 */
	public ImageEntry[] getAllResults()
	{
		if (this.list.size() == 0)
		{
			return null;
		}
		else
		{
			ImageEntry[] result = new ImageEntry[this.list.size()];
			return (ImageEntry[]) this.list.toArray(result);
		}
	}
	
	/**
	 * Retrieves the number of entries contained in this ResultSet.
	 * @return The number of entries that have been added.
	 */
	public int getNumEntries()
	{
		return this.list.size();
	}
	
	/**
	 * Predicate method to check whether a url for an image has already been added in this ResultSet on any page.
	 * @param url - The image url to check for.
	 * @return true if the url has been previously added to this ResultSet in any ImageEntry
	 */
	public boolean contains(String url)
	{
		return this.list.contains(new ImageEntry(url, url));
	}
}
