// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package scraper.utils;

import java.io.IOException;
import org.jsoup.Jsoup;

/**
 * This class represents a full HTML document made up of a series of elements. It provides methods
 * for loading a document from a web-page, a local file, or a String of HTML tags. Documents can be
 * queried to retrieve elements that match a given tag.
 * @author lmears, jacobsand
 */
public class Document
{
	/**
	 * Boolean that represents if the page is loaded.
	 */
	private boolean loaded = false;
	/**
	 * Document to use in the class.
	 */
	private org.jsoup.nodes.Document doc = null;
	
	/**
	 * Creates an empty document object whose contents have not been loaded yet.
	 */
	public Document()
	{
		
	}
	
	/**
	 * Loads a static string of HTML into this Document to enable queries to be performed.
	 * @param theHTML - A string of well-formed HTML to be parsed by the Document.
	 * @return true if the specified HTML was successfully loaded by the Document; false if an error
	 * occurred while loading.
	 */
	public boolean loadPageFromHTML(String theHTML)
	{
		this.doc = Jsoup.parse(theHTML);
		this.loaded = true;
		return this.loaded;
	}
	
	/**
	 * Loads the contents of a webpage into this Document based on an absolute URL (ie., including
	 * the http:// or https:// portion).
	 * @param theURL - An absolute URL for the page to be loaded into this Document. 
	 * @return true if the HTML for the corresponding URL was successfully loaded by the Document; false if
	 * an error occurred while loading.
	 */
	public boolean loadPageFromURL(String theURL)
	{
		try
		{
			this.doc = Jsoup.connect(theURL).get();
			this.loaded = true;
		}
		catch (IOException var3) {
			this.loaded = false;
		}
		return this.loaded;
	}
	
	public Elements getElementsByTag(String tag)
	{
		return new Elements(this.doc.getElementsByTag(tag));
	}
}
