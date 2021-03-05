// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package scraper.base;

/**
 * This class provides a simple mechanism to crawl a series of webpages recursively and extract all
 * of the images that are found on the pages visited.
 * @author lmears, jacobsand
 */
public class WebScraper
{
	/**
	 * Builds a new WebScraper that should start at the provided URL and will by default explore that
	 * page at a depth of 0. This allows extracting just the details from this page and nothing else.
	 * @param urlIn - The URL to explore for images.
	 */
	public WebScraper(String urlIn)
	{
		
	}
	
	/**
	 * Builds a new WebScraper that should start at the provided URL and will explore recursively
	 * to a specified depth.
	 * @param urlIn - The URL to begin exploring for images.
	 * @param depthIn - The recursive depth to explore, must be >= 0. Negative values will be treated as
	 * equivalent to 0.
	 */
	public WebScraper(String urlIn, int depthIn)
	{
		
	}
	
	/**
	 * Updates this WebScraper to explore to a new depth.
	 * @param depthIn - The recursive depth to explore, must be >= 0. Negative values will be treated as
	 * equivalent to 0.
	 */
	public void setDepth(int depthIn)
	{
		
	}
	
	/**
	 * Retrieves the exploration depth of this WebScraper.
	 * @return The depth stored in this WebScraper.
	 */
	public int getDepth()
	{
		return 0;
	}
	
	/**
	 * Updates the base URL to explore for this WebScraper.
	 * @param url - The new URL to explore. The WebScraper url is only changed if the url value
	 * is valid (not null or empty).
	 */
	public void setURL(String url)
	{
		
	}
	
	/**
	 * Retrieves the base url for exploration by this WebScraper.
	 * @return The base url.
	 */
	public String getURL()
	{
		return "";
	}
}
