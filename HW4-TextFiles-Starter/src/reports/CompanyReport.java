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
 * A report for a single company of Fortune 500 data.
 * Report includes the minimum, maximum, average, and standard deviation of revenues, profits, and rank
 * for all years in which the company was ranked in the Fortune 500.
 *
 * @author lmears, jacobsand
 */
public class CompanyReport implements Report
{
	/**
	 * Company Name that the Report is about.
	 */
	private String companyName;
	/**
	 * File containing the information to be read.
	 */
	private File inputFile;
	/**
	 * Array containing the year data.
	 */
	private Integer[] yearData;
	/**
	 * Array containing the revenue data.
	 */
	private Double[] revenueData;
	/**
	 * Array containing the profit data.
	 */
	private Double[] profitData;
	/**
	 * Array containing the rank data.
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
	private double minprofit;
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
	 * Minimum Rank.
	 */
	private int minrank;
	/**
	 * Maximum Rank.
	 */
	private int maxrank;
	/**
	 * Average Rank.
	 */
	private double avgrank;
	/**
	 * Standard Deviation of Rank.
	 */
	private double stdrank;
	/**
	 * Boolean storing didReport for toString.
	 */
	private boolean didReport;

	/**
	 * Creates new CompanyReport for given company; data to be read from given file.
	 *
	 * @param inputFileIn - File containing Fortune 500 data for this report.
	 * @param companyIn   - Company to report Fortune 500 data.
	 */
	public CompanyReport(File inputFileIn, String companyIn)
	{
		this.companyName = companyIn;
		inputFile = inputFileIn;
	}

	/**
	 * Reads data from Fortune 500 data file; processes the data.
	 * The file is a csv file and can be assumed is formatted correctly.
	 * See supplemental document for details on reading from csv files.
	 * Calculates the minimum, maximum, average, and standard deviation of revenues, profits, and rank
	 * for all years the company is ranked using tools in the Data class.
	 *
	 * @return true if processing successful, false if the input file does not exist.
	 */
	public boolean processReport()
	{
		// Using report interface to sort things into CSV categories.

		// Declaring ArrayLists to store data from the file.
		ArrayList<Integer> yearDataTmp = new ArrayList<Integer>();
		ArrayList<Integer> rankDataTmp = new ArrayList<Integer>();
		ArrayList<Double> revenueDataTmp = new ArrayList<Double>();
		ArrayList<Double> profitDataTmp = new ArrayList<Double>();


		try
		{
			Scanner sc = new Scanner(inputFile);
			// Loops through this block while there is content to read.
			while (sc.hasNext())
			{
				String[] mapping = sc.nextLine().split(",");

				// Use entries that match the company name.
				if (mapping[Report.COMPANY_LOC].equals(this.companyName))
				{
					yearDataTmp.add(Integer.parseInt(mapping[Report.YEAR_LOC]));
					rankDataTmp.add(Integer.parseInt(mapping[Report.RANK_LOC]));
					revenueDataTmp.add(Double.parseDouble(mapping[Report.REVENUE_LOC]));
					profitDataTmp.add(Double.parseDouble(mapping[Report.PROFIT_LOC]));
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

			this.minprofit = Data.minimum(this.profitData);
			this.avgprofit = Data.average(this.profitData);
			this.maxprofit = Data.maximum(this.profitData);
			this.stdprofit = Data.standardDeviation(this.profitData);

			this.minrank = Data.minimum(this.rankData);
			this.maxrank = Data.maximum(this.rankData);
			this.avgrank = Data.average(this.rankData);
			this.stdrank = Data.standardDeviation(this.rankData);
			this.rank = this.rankData.length;

			this.didReport = true;
			return true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not Found");
			this.didReport = false;
			return false;
		}
	}

	/**
	 * Writes the processed report to the given file.
	 * The given file's contents will look like the result of calling CompanyReport's toString.
	 *
	 * @param outputFile - File to write report to.
	 * @return true if write successful, false if file cannot be created.
	 * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been processed.
	 */
	public boolean writeReport(File outputFile) throws DataNotProcessedException
	{
		if (this.didReport)
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
		else
		{
			throw new DataNotProcessedException();
		}


	}

	/**
	 * Returns a formatted String of this report suitable for writing to an output file. String is of the form:
	 * <p>
	 * Fortune 500 Report for COMPANY ranked RANKED times
	 * Revenue
	 * Min: minimumreven Max: maximumreven Avg: avergreve StD: stanardivreven
	 * Profit
	 * Min: minprofit Max: maxprofit Avg: avgprofit StD: stdprofit
	 * Rank
	 * Min: MINRANK Max: MAXRANK Avg: AVGRANK StD: STDRANK
	 * <p>
	 * Where COMPANY is the company, RANKED is the number of times the company has been ranked in
	 * the file, minimumreven, maximumreven, avergreve, stanardivreven are the minimum, maximum, average,
	 * and standard deviation of revenues, minprofit, maxprofit, avgprofit, stdprofit are the minimum,
	 * maximum, average, and standard deviation of profits, and MINRANK, MAXRANK, AVGRANK, STDRANK
	 * are the minimum, maximum, average, and standard deviation of rank.
	 * These are all floating point values formatted to exactly three decimals except for MINRANK and MAXRANK
	 * which are whole number values.
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
			return String.format("Fortune 500 Report for %s ranked %d times\n"
							+ "Revenue\n"
							+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f\n"
							+ "Profit\n"
							+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f\n"
							+ "Rank\n"
							+ "Min: %d Max: %d Avg: %.3f StD: %.3f", this.companyName,
					this.rank, this.minimumreven, this.maximumreven, this.avergreve,
					this.stanardivreven, this.minprofit, this.maxprofit, this.avgprofit,
					this.stdprofit, this.minrank, this.maxrank, this.avgrank, this.stdrank);
		}
		else
		{
			return String.format("Fortune 500 Report for %s ranked 0 times\n"
					+ "Revenue\n"
					+ "Min: nul Max: nul Avg: nul StD: nul\n"
					+ "Profit\n"
					+ "Min: nul Max: nul Avg: nul StD: nul\n"
					+ "Rank\n"
					+ "Min: null Max: null Avg: nul StD: nul", this.companyName);

		}
	}

	/**
	 * Returns the company of this report.
	 *
	 * @return Company of this report.
	 */
	public String getCompany()
	{
		return this.companyName;
	}

}

