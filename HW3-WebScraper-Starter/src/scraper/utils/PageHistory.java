// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package scraper.utils;
import java.util.LinkedList;

/**
 * This class provides a simple web-history tracking mechanism.
 * @author lmears, jacobsand
 */
public class PageHistory
{
	/**
	 * Linked list that stores the web pages visited in chronological order.
	 */
	private LinkedList<String> history = new LinkedList<String>();
	/**
	 * Boolean that represents if the website visited is a duplicate.
	 */
	private boolean duplicates = false;
	
	/**
	 * Creates a new empty PageHistory object.
	 */
	public PageHistory()
	{
		
	}
	
	/**
	 * Stores a given url in the PageHistory to indicate that the page at that url has been previously visited.
	 * @param url - The page that has been visited.
	 */
	public void markVisited(String url)
	{
		if (this.visited(url)) {
			this.duplicates = true;
		}
		this.history.add(url);
	}
	
	/**
	 * A predicate method to check whether a particular page has been visited before in the history.
	 * @param url - The page to check for in the history.
	 * @return true if url already exists somewhere in this PageHistory object, false if the page has not
	 * been markedVisited in the past.
	 */
	public boolean visited(String url)
	{
		return this.history.contains(url);
	}
	
	/**
	 * Retrieves the full history of this PageHistory object as an array of strings. The array values are
	 * stored in chronological order of visits, with index 0 corresponding to the first page visited in the
	 * life of this PageHistory object.
	 * @return an array of all pages markVisted by this PageHistory
	 */
	public String[] getHistory()
	{
		String[] output = new String[this.history.size()];
		return (String[]) this.history.toArray(output);
	}
	
	/**
	 * A predicate method that indicates if at any point in this PageHistory's lifespan any URL was
	 * "markVisited" more than once.
	 * @return true if a page revisit occurred at some point; false otherwise
	 */
	public boolean wereDuplicatesVisited()
	{
		return this.duplicates;
	}
}
