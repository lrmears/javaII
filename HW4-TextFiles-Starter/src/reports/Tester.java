package reports;

import java.io.File;

// simple test file to use before doing Junit tests
public class Tester
{

	public static void main(String[] args)
	{
		File inputFile = new File("fortune500.csv");
		CompanyReport d = new CompanyReport(inputFile, "Witco");
		d.processReport();
		System.out.println(d.toString());

	}

}
