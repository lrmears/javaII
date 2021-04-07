package reports;

import java.io.File;
// simple test file to use before doing Junit tests
public class Tester {

	public static void main(String[] args) {
		File inputFile = new File("fortune500.csv");
		YearReport d = new YearReport(inputFile, 1980);
		d.processReport();
		System.out.println(d.toString());

	}

}
