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

public class WebScraperTest 
{

	@Test
	public void webScraperConstructorTest()
	{
		String testA = "http://kreestman.unomaha.community/hw3testpage/page0.html";
		String testB = "http://kreestman.unomaha.community/hw3testpage/page1.html";
		String testC = "http://kreestman.unomaha.community/hw3testpage/page2.html";
		WebScraper a = new WebScraper(testA);
		assertEquals(0, a.getDepth());
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page0.html", a.getURL());
		a.setURL(testB);
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page1.html", a.getURL());
		a.setDepth(9);
		assertEquals(9, a.getDepth());
		a.setDepth(-9);
		assertEquals(0, a.getDepth());
		a.setURL("");
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page1.html", a.getURL());
		WebScraper b = new WebScraper(testA, 3);
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page0.html", b.getURL());
		assertEquals(3, b.getDepth());
		assertEquals(2, a.getImages().getNumEntries());
		WebScraper c = new WebScraper(testC);
		assertEquals(13, c.getImages().getNumEntries());
	}
	
	@Test
	public void setDepthTest()
	{

	}
	
	@Test
	public void getDepthTest()
	{
		
	}
	
	@Test
	public void setURLTest()
	{
		
	}
	
	@Test
	public void getURLTest()
	{
		
	}
	
	@Test
	public void getImagesTest()
	{
		
	}
	
	@Test
	public void getImagesHelperTest()
	{
		
	}
	
	@Test
	public void crawlPageTest()
	{
		
	}
	
	@Test
	public void crawlPageHelperTest()
	{
		
	}
	
	@Test
	public void getPageHistoryTest()
	{
		
	}

}
