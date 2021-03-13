// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package scraper.utils;

/**
 * This class provides a simple web-history tracking mechanism.
 * @author lmears, jacobsand
 */
public class PageHistory
{
	/**
	 * history.
	 */
	private String[] history;
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
	public void markVisited(java.lang.String url)
	{
		
	}
	
	/**
	 * A predicate method to check whether a particular page has been visited before in the history.
	 * @param url - The page to check for in the history.
	 * @return true if url already exists somewhere in this PageHistory object, false if the page has not
	 * been markedVisited in the past.
	 */
	public boolean visited(java.lang.String url)
	{
		return true;
	}
	
	/**
	 * Retrieves the full history of this PageHistory object as an array of strings. The array values are
	 * stored in chronological order of visits, with index 0 corresponding to the first page visited in the
	 * life of this PageHistory object.
	 * @return an array of all pages markVisted by this PageHistory
	 */
	public String[] getHistory()
	{
		return history;
	}
	
	/**
	 * A predicate method that indicates if at any point in this PageHistory's lifespan any URL was
	 * "markVisited" more than once.
	 * @return true if a page revisit occurred at some point; false otherwise
	 */
	public boolean wereDuplicatesVisited()
	{
		return true;
	}
}
