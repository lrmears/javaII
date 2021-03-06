// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import analytics.Data;

/**
 * A report for a single year of Fortune 500 data.
 * Report includes the minimum, maximum, average, and standard deviation of revenues and profits
 * for all ranked companies of the report's year.
 *
 * @author lmears, jacobsand
 */
public class YearReport implements Report
{
	/**
	 * File containing the information to be read.
	 */
	private File inputFile;
	/**
	 * Array that stores the year data.
	 */
	private Integer[] yearData;
	/**
	 * Array that stores the revenue data.
	 */
	private Double[] revenueData;
	/**
	 * Array that stores the profit data.
	 */
	private Double[] profitData;
	/**
	 * Array that stores the rank data.
	 */
	private Integer[] rankData;
	/**
	 * Company Rank.
	 */
	private int rank;
	/**
	 * Company Minimum Revenue.
	 */
	private double minimumreven;
	/**
	 * Maximum Revenue.
	 */
	private double avergreve;
	/**
	 * Average Revenue.
	 */
	private double maximumreven;
	/**
	 * Standard deviation of revenue.
	 */
	private double stanardivreven;
	/**
	 * Minimum profit.
	 */
	private double minprofitfit;
	/**
	 * Maximum Profit.
	 */
	private double maxprofit;
	/**
	 * Average Profit.
	 */
	private double avgprofit;
	/**
	 * Standard deviation of profit.
	 */
	private double stdprofit;
	/**
	 * Variable storing the year.
	 */
	private int year;
	/**
	 * Boolean storing didReport for toString.
	 */
	private boolean didReport;

	/**
	 * Creates new YearReport for given year; data to be read from given file.
	 *
	 * @param inputFileIn - File containing Fortune 500 data for this report.
	 * @param yearIn      - Year to report Fortune 500 data.
	 */
	public YearReport(File inputFileIn, int yearIn)
	{
		this.year = yearIn;
		this.inputFile = inputFileIn;
	}

	/**
	 * Reads data from Fortune 500 data file; processes the data.
	 * The file is a csv file and can be assumed is formatted correctly.
	 * See supplemental document for details on reading from csv files.
	 * Calculates the minimum, maximum, average, and standard deviation of revenues and profits
	 * for all ranked companies of the report's year using tools in the Data class.
	 *
	 * @return true if processing successful, false if the input file does not exist.
	 * @throws YearNotFoundException - Thrown if the report's year is not present in the data file.
	 */
	public boolean processReport()
	{
		// Variables that store locations.
		final int YEAR = Report.YEAR_LOC;
		final int RANK = Report.RANK_LOC;
		final int COMPANY_NAME = Report.COMPANY_LOC;
		final int REVENUE = Report.REVENUE_LOC;
		final int PROFIT = Report.PROFIT_LOC;

		ArrayList<Integer> yearDataTmp = new ArrayList<Integer>();
		ArrayList<Integer> rankDataTmp = new ArrayList<Integer>();
		ArrayList<Double> revenueDataTmp = new ArrayList<Double>();
		ArrayList<Double> profitDataTmp = new ArrayList<Double>();

		if (this.year > MAXYEAR || this.year < MINYEAR)
		{
			throw new YearNotFoundException();
		}
		else
		{

			try
			{
				Scanner sc = new Scanner(inputFile);

				while (sc.hasNext())
				{
					String[] mapping = sc.nextLine().split(",");

					// we only care about entries for our specific company
					if (mapping[YEAR].equals(Integer.toString(this.year)))
					{
						yearDataTmp.add(Integer.parseInt(mapping[YEAR]));
						rankDataTmp.add(Integer.parseInt(mapping[RANK]));
						revenueDataTmp.add(Double.parseDouble(mapping[REVENUE]));
						profitDataTmp.add(Double.parseDouble(mapping[PROFIT]));
					}
				}
				sc.close();
				int numEntries = yearDataTmp.size();

				this.yearData = new Integer[numEntries];
				this.rankData = new Integer[numEntries];
				this.revenueData = new Double[numEntries];
				this.profitData = new Double[numEntries];

				for (int i = 0; i < numEntries; ++i)
				{
					this.yearData[i] = yearDataTmp.get(i);
					this.rankData[i] = rankDataTmp.get(i);
					this.revenueData[i] = revenueDataTmp.get(i);
					this.profitData[i] = profitDataTmp.get(i);
				}

				this.minimumreven = Data.minimum(this.revenueData);
				this.avergreve = Data.average(this.revenueData);
				this.maximumreven = Data.maximum(this.revenueData);
				this.stanardivreven = Data.standardDeviation(this.revenueData);

				this.minprofitfit = Data.minimum(this.profitData);
				this.avgprofit = Data.average(this.profitData);
				this.maxprofit = Data.maximum(this.profitData);
				this.stdprofit = Data.standardDeviation(this.profitData);
				this.didReport = true;
				return true;
			}
			catch (FileNotFoundException e)
			{
				System.out.println("File not Found");
				this.didReport = true;
				return false;
			}
		}

	}

	/**
	 * Writes the processed report to the given file.
	 * The given file's contents will look like the result of calling YearReport's toString.
	 *
	 * @param outputFile - File to write report to.
	 * @return true if write successful, false if file cannot be created.
	 * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been processed.
	 */
	public boolean writeReport(File outputFile) throws DataNotProcessedException
	{
		try
		{
			FileOutputStream fileout = new FileOutputStream(outputFile, false);
			PrintWriter writer = new PrintWriter(fileout);
			writer.print(this.toString());

			writer.close();

			return true;
		}
		catch (FileNotFoundException e)
		{

			System.out.println("File not Found");
			return false;
		}
	}

	/**
	 * Returns a formatted String of this report suitable for writing to an output file. String is of the form:
	 * <p>
	 * Fortune 500 Report for YEAR
	 * Revenue
	 * Min: minimumreven Max: maximumreven Avg: avergreve StD: stanardivreven
	 * Profit
	 * Min: minprofitfit Max: maxprofit Avg: avgprofit StD: stdprofit
	 * <p>
	 * Where YEAR is the year of the report, minimumreven, maximumreven, avergreve, stanardivreven are the
	 * minimum, maximum, average, and standard deviation of revenues, and
	 * minprofitfit, maxprofit, avgprofit, stdprofit are the minimum, maximum, average, and standard
	 * deviation of profits.
	 * These are all floating point values formatted to exactly three decimals
	 * except for YEAR which is a whole number value.
	 * NOTE: There are no blank lines before, after, or between the lines, and the String DOES NOT
	 * end in a new line.
	 * If your toString is not formatted exactly most tests will fail.
	 * A JUnit test for this method is provided in the tests package to ensure your formatting is correct.
	 * Additionally, remember that all are formatted to exactly three decimal places,
	 * which will explain any "nul"s you see in the provided test case.
	 */
	@Override
	public String toString()
	{
		if (this.didReport)
		{
			return String.format("Fortune 500 Report for %d\n"
							+ "Revenue\n"
							+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f\n"
							+ "Profit\n"
							+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f", this.year,
					this.minimumreven, this.maximumreven, this.avergreve, this.stanardivreven,
					this.minprofitfit, this.maxprofit, this.stdprofit, this.avgprofit);
		}
		else
		{
			return String.format("Fortune 500 Report for %d\n"
					+ "Revenue\n"
					+ "Min: nul Max: nul Avg: nul StD: nul\n"
					+ "Profit\n"
					+ "Min: nul Max: nul Avg: nul StD: nul", this.year);
		}
	}

	/**
	 * Returns the year of this report.
	 *
	 * @return Year of this report.
	 */
	public int getYear()
	{
		return this.year;
	}

}


