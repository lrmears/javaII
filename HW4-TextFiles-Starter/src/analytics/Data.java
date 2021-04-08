// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears, Jacob Sand
// RESOURCES: I used not external resources in creating this class.

package analytics;

/**
 * Set of useful reusable tools for analyzing sets of data.
 *
 * @author lmears, jacobsand
 */
public class Data
{
	/**
	 * Finds the minimum value in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 *
	 * @param <E>  - Type of data passed. The type must implement the Comparable interface.
	 * @param data - Collection of data to find minimum value of.
	 * @return Minimum value in passed data.
	 */
	public static <E extends Comparable<E>> E minimum(E[] data)
	{
		E minValue;
		if (data.length > 0)
		{
			minValue = data[0];
			for (int i = 1; i < data.length; i++)
			{
				if (data[i] == null)
				{
					break;
				}
				if (minValue.compareTo(data[i]) > 0)
				{
					// Sets minValue to current item if it is less than the current minValue.
					minValue = data[i];
				}
			}
		}
		else
		{
			minValue = null;
		}
		return minValue;
	}

	/**
	 * Finds the maximum value in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 *
	 * @param <E>  - Type of data passed. The type must implement the Comparable interface.
	 * @param data - Collection of data to find maximum value of.
	 * @return Maximum value in passed data.
	 */
	public static <E extends Comparable<E>> E maximum(E[] data)
	{
		// Declares maximum value to be the first value of the array.
		E maxValue = data[0];
		// Starts at index 1 due to the above line.
		for (int i = 1; i < data.length; i++)
		{
			if (data[i] == null)
			{
				break;
			}
			if (maxValue.compareTo(data[i]) < 0)
			{
				// Sets maxValue to current item if it is more than the current maxValue.
				maxValue = data[i];
			}
		}
		return maxValue;
	}

	/**
	 * Finds the average of values in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 *
	 * @param <N>  - Type of data passed. The type must extend the Number class.
	 *             See the assignment supplemental for useful information on the Number class.
	 * @param data - Collection of data to find average of.
	 * @return Average of passed data. Regardless of type passed will always return a Double.
	 * This means if no results are in data it will return Double's "Divide By 0" value, NaN,
	 * which it should do automatically.
	 */
	public static <N extends Number> Double average(N[] data)
	{
		double total = 0, count = 0;
		for (int i = 0; i < data.length && data[i] != null; i++)
		{
			total += data[i].doubleValue();
			++count;
		}
		if (count == 0)
		{
			return 0.0;
		}
		else
		{
			return total / count;
		}
	}

	/**
	 * Finds the population standard deviation of values in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 *
	 * @param <N>  - Type of data passed. The type must extend the Number class.
	 *             See the assignment supplemental for useful information on the Number class.
	 * @param data - Collection of data to find standard deviation of.
	 * @return Population Standard Deviation of passed data. Regardless of type passed will always return a Double.
	 * This means if no results are in data it will return Double's "Divide By 0" value, NaN,
	 * which it should do automatically.
	 */
	public static <N extends Number> Double standardDeviation(N[] data)
	{
		double standardDevi = 0.0, mean = 0.0, total = 0, count = 0;
		// starting variables for double
		int dataLength = 0; // array length variable
		for (int i = 0; i < data.length && data[i] != null; i++) // average tool from the previous method
		{
			total += data[i].doubleValue();
			++count;
		}
		if (count == 0)
		{
			return 0.0;
		}
		else
		{
			mean = total / count;
		}
		for (Number num : data)
		{
			if (num == null)
			{
				break;
			}
			standardDevi += Math.pow(num.doubleValue() - mean, 2);
		}
		for (int i = 0; i < data.length && data[i] != null; i++)
		{
			dataLength++;
		}

		return Math.sqrt(standardDevi / dataLength);
	}
}
