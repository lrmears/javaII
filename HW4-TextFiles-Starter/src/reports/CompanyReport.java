// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package reports;

import java.io.File;

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
     * Creates new CompanyReport for given company; data to be read from given file.
     *
     * @param inputFileIn - File containing Fortune 500 data for this report.
     * @param companyIn   - Company to report Fortune 500 data.
     */
    public CompanyReport(File inputFileIn, String companyIn)
    {

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
        return false;
    }

    /**
     * Writes the processed report to the given file.
     * The given file's contents will look like the result of calling CompanyReport's toString.
     *
     * @param outputFile - File to write report to.
     * @return true if write successful, false if file cannot be created.
     * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been processed.
     */
    public boolean writeReport(File outputFile)
    {
        return false;
    }

    /**
     * Returns a formatted String of this report suitable for writing to an output file. String is of the form:
     * <p>
     * Fortune 500 Report for COMPANY ranked RANKED times
     * Revenue
     * Min: MINREV Max: MAXREV Avg: AVGREV StD: STDREV
     * Profit
     * Min: MINPRO Max: MAXPRO Avg: AVGPRO StD: STDPRO
     * Rank
     * Min: MINRANK Max: MAXRANK Avg: AVGRANK StD: STDRANK
     * <p>
     * Where COMPANY is the company, RANKED is the number of times the company has been ranked in the file,
     * MINREV, MAXREV, AVGREV, STDREV are the minimum, maximum, average, and standard deviation of revenues,
     * MINPRO, MAXPRO, AVGPRO, STDPRO are the minimum, maximum, average, and standard deviation of profits,
     * and MINRANK, MAXRANK, AVGRANK, STDRANK are the minimum, maximum, average, and standard deviation of rank.
     * These are all floating point values formatted to exactly three decimals except for MINRANK and MAXRANK
     * which are whole number values.
     * NOTE: There are no blank lines before, after, or between the lines, and the String DOES NOT end in a new line.
     * If your toString is not formatted exactly most tests will fail.
     * A JUnit test for this method is provided in the tests package to ensure your formatting is correct.
     * Additionally, remember that all are formatted to exactly three decimal places,
     * which will explain any "nul"s you see in the provided test case.
     */
    @Override
    public String toString()
    {
        return null;
    }

    /**
     * Returns the company of this report.
     *
     * @return Company of this report.
     */
    public String getCompany()
    {
        return null;
    }

}
