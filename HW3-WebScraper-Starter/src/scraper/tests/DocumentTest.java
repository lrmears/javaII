// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package scraper.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import scraper.utils.*;
import scraper.base.*;

public class DocumentTest
{

	@Test
	public void loadPageFromHTMLTest()
	{
		Document page = new Document();
		assertEquals(true, page.loadPageFromHTML("http://kreestman.unomaha.community/hw3testpage/page0.html"));
	}
	
	@Test
	public void loadPageFromURLTest()
	{
		Document page = new Document();
		assertEquals(true, page.loadPageFromURL("http://kreestman.unomaha.community/hw3testpage/page0.html"));
	}
	
	@Test
	public void getElementsByTagTest()
	{
		Document page = new Document();
		
	}

}
