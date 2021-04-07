package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import analytics.Data;

public class DataTest
{

	@Test
	/**
	 * Test to see if the minimum Value method functions normally
	 */
	public void minimumValueTest()
	{
		Double[] doubleArray = {9.9, 2.5, 9.1, 7.2, 1.1, 2.3, 7.4};
		double minimumValue = Data.minimum(doubleArray);
		assertEquals(1.1, minimumValue, 0.1);
	}

	@Test
	/**
	 * Tests to see if the minimum value method functions with a null thrown in
	 * and a smaller value post null
	 */
	public void minimumValueNullTest()
	{
		Double[] doubleArray = {9.9, 2.5, 9.1, 7.2, null, 2.3, 7.4};
		double minimumValue = Data.minimum(doubleArray);
		assertEquals(2.5, minimumValue, 0.1);
	}

	@Test
	/**
	 * Tests to see if the maximum value method functions normally
	 */
	public void maximumValueTest()
	{
		Double[] doubleArray = {9.7, 2.5, 9.9, 7.2, 1.1, 2.3, 7.4};
		double maximumValue = Data.maximum(doubleArray);
		assertEquals(9.9, maximumValue, 0.1);
	}

	@Test
	/**
	 * Tests to see if the maximum value method functions with a null 
	 * thrown in and with a larger value later
	 */
	public void maximumValueNullTest()
	{
		Double[] doubleArray = {9.7, 2.5, null, 7.2, 1.1, 2.3, 9.9};
		double maximumValue = Data.maximum(doubleArray);
		assertEquals(9.7, maximumValue, 0.1);
	}

	@Test
	/**
	 * Tests to see if the average method functions normally
	 */
	public void averageValueTest()
	{
		Double[] doubleArray = {9.7, 2.5, 9.9, 7.2, 1.1, 2.3, 7.4};
		double averageValue = Data.average(doubleArray);
		assertEquals(5.7, averageValue, 0.1);
	}

	@Test
	/**
	 * Tests to see if a divide by zero case returns the correct item
	 */
	public void averageValueDivZeroTest()
	{
		Double[] doubleArray = {};
		double averageValue = Data.average(doubleArray);
		assertEquals(0.0, averageValue, 0.1);
	}

	@Test
	/**
	 * Tests to see if the average class functions properly with a null value inserted
	 */
	public void averageValueNullTest()
	{
		Double[] doubleArray = {9.7, 2.5, 9.9, 7.2, null, 2.3, 7.4};
		double averageValue = Data.average(doubleArray);
		assertEquals(7.3, averageValue, 0.1);
	}

	@Test
	/**
	 * Tests to see if the standard deviation method works
	 */
	public void standardDeviationTest()
	{
		Double[] doubleArray = {9.7, 2.5, 9.9, 7.2, 1.1, 2.3, 7.4};
		double standardDeviation = Data.standardDeviation(doubleArray);
		assertEquals(3.4, standardDeviation, 0.1);
	}

	@Test
	/**
	 * Tests to see if the standard deviation method works with a null
	 */
	public void standardDeviationNullTest()
	{
		Double[] doubleArray = {9.7, 2.5, 9.9, 7.2, null, 2.3, 7.4};
		double standardDeviation = Data.standardDeviation(doubleArray);
		assertEquals(2.9, standardDeviation, 0.1);
	}

	@Test
	/**
	 * Tests to see if given no values returns 0.0
	 */
	public void standardDeviationZeroTest()
	{
		Double[] doubleArray = {};
		double standardDeviation = Data.standardDeviation(doubleArray);
		assertEquals(0.0, standardDeviation, 0.1);
	}

	@Test
	/**
	 * Tests the data class overall
	 */
	public void dataTest()
	{
		Double[] doubleArray = {9.7, 2.5, 9.9, 7.2, 1.1, 2.3, 7.4};
		double standardDeviation = Data.standardDeviation(doubleArray);
		assertEquals(3.4, standardDeviation, 0.1);
		double maximumValue = Data.maximum(doubleArray);
		assertEquals(9.9, maximumValue, 0.1);
		double minimumValue = Data.minimum(doubleArray);
		assertEquals(1.1, minimumValue, 0.1);
		double averageValue = Data.average(doubleArray);
		assertEquals(5.7, averageValue, 0.1);
	}

}
