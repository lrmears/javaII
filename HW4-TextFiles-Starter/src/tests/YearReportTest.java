// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import reports.CompanyReport;
import reports.YearNotFoundException;
import reports.YearReport;

public class YearReportTest
{

	@Test
	public void unprocessedToStringTest()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 2020);
		String expected = "Fortune 500 Report for 2020\n"
				+ "Revenue\n"
				+ "Min: nul Max: nul Avg: nul StD: nul\n"
				+ "Profit\n"
				+ "Min: nul Max: nul Avg: nul StD: nul";

		assertEquals("Problem in YearReport basic toString format, check spelling, capitalization,"
				+ "spacing, and format", expected, y.toString());
	}

	@Test
	public void basicYearToStringTest()
	{
		File inputFile = new File("fortune500.csv");
		YearReport d = new YearReport(inputFile, 1980);
		d.processReport();
		assertEquals("Fortune 500 Report for 1980\n"
				+ "Revenue\n"
				+ "Min: 409.700 Max: 79106.500 Avg: 2890.625 StD: 6317.787\n"
				+ "Profit\n"
				+ "Min: -1097.300 Max: 4295.200 Avg: 356.229 StD: 156.707", d.toString());

	}
	@Test(expected = YearNotFoundException.class)
	public void yearNotFoundExecption()
	{
		File inputFile = new File("fortune500.csv");
		YearReport d = new YearReport(inputFile, 2100);
		d.processReport();
	}
	
	@Test
	public void fileNotFoundTest()
	{
		File inputFile = new File("fortune50.csv");
		CompanyReport d = new CompanyReport(inputFile, "Witco");
		assertFalse(d.processReport());
	}
	@Test
	public void yearConstructMethodTest()
	{
		YearReport z = new YearReport(new File("fortune500.csv"), 1980);
		
		assertEquals(z.getYear(), 1980);
	}
	@Test
	public void proccessYearReportTrue()
	{
		YearReport z = new YearReport(new File("fortune500.csv"), 1980);
		
		assertEquals(z.processReport(), true);
		
		assertEquals(z.getYear(), 1980);
	}
	@Test
	public void getYearAsZeroTest()
	{
		YearReport z = new YearReport(new File("fortune500.csv"), 2020);
		
		assertEquals(z.getYear(), 2020);
	}

}

