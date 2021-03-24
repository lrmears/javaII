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

public class ImageEntryTest 
{

	@Test
	public void imageEntryConstructorTest()
	{
		String testA = "http://kreestman.unomaha.community/hw3testpage/page2.html";
		String testB = "http://kreestman.unomaha.community/hw3testpage/imgs/Palm_Tree_Emoji_42x42.png";
		ImageEntry a = new ImageEntry(testA, testB);
		assertEquals("http://kreestman.unomaha.community/hw3testpage/imgs/Palm_Tree_Emoji_42x42.png", a.getImgLocation());
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page2.html", a.getPageLocation());
		
	}
	
	@Test
	public void getImgLocationTest()
	{
		
	}
	
	@Test
	public void equalsTest()
	{
		
	}
	
	@Test
	public void toStringTest()
	{
		
	}

}
