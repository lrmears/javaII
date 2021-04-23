// COURSE: CSCI1620
// TERM: SPRING 2021
// 
// NAME: Jacob Sand, Logan Mears
// RESOURCES: No outside resources were used in the creation of this class.
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

import molecule.Molecule;
import molecule.MoleculeCollection;
import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

public class MoleculeTest
{
	/**
	 * Variable to use in test cases.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;

	@Test
	public void constructorTest()
	{
		Molecule a = new Molecule("CHO");

		assertEquals(a.getSequence(), "CHO");
		assertEquals(a.getWeight(), 29, DOUBLE_TOLERANCE);

	}

	@Test(expected = InvalidAtomException.class)
	public void constructorFTest()
	{
		Molecule a = new Molecule("CAO");

		assertEquals(a.getSequence(), "Invalid Atom Value: A");
		assertEquals(a.getWeight(), 29, DOUBLE_TOLERANCE);

	}

	@Test(expected = InvalidSequenceException.class)
	public void constructorFailTest()
	{
		Molecule a = new Molecule("(CHO");

		assertEquals(a.getSequence(), "Invalid Atom Value: A");
		assertEquals(a.getWeight(), 29, DOUBLE_TOLERANCE);

	}

	@Test
	public void setSequenceTest()
	{
		Molecule a = new Molecule("CHO");
		assertEquals(a.getSequence(), "CHO");
		assertEquals(a.getWeight(), 29, DOUBLE_TOLERANCE);

		a.setSequence("CH");
		assertEquals(a.getSequence(), "CH");
		assertEquals(a.getWeight(), 13, DOUBLE_TOLERANCE);

	}

	@Test
	public void getSequenceTest()
	{
		Molecule a = new Molecule("CHO");
		assertEquals(a.getSequence(), "CHO");
	}

	@Test
	public void getWeightTest()
	{
		Molecule a = new Molecule("CHO");
		assertEquals(a.getWeight(), 29, DOUBLE_TOLERANCE);
	}

	@Test
	public void toStringTest()
	{
		Molecule a = new Molecule("CHO");
		assertEquals(a.getSequence(), "CHO");
		assertEquals(a.getWeight(), 29, DOUBLE_TOLERANCE);
		String b = "CHO                      : 29";
		assertEquals(b, a.toString());

	}

	@Test
	public void atomicWeightCTest()
	{
		Molecule a = new Molecule("C");
		assertEquals(12, a.getWeight(), DOUBLE_TOLERANCE);

		Molecule b = new Molecule("c");
		assertEquals(12, b.getWeight(), DOUBLE_TOLERANCE);
	}

	@Test
	public void atomicWeightHTest()
	{
		Molecule a = new Molecule("H");
		assertEquals(1, a.getWeight(), DOUBLE_TOLERANCE);

		Molecule b = new Molecule("h");
		assertEquals(1, b.getWeight(), DOUBLE_TOLERANCE);

	}

	@Test
	public void atomicWeightOTest()
	{
		Molecule a = new Molecule("O");
		assertEquals(16, a.getWeight(), DOUBLE_TOLERANCE);

		Molecule b = new Molecule("o");
		assertEquals(16, b.getWeight(), DOUBLE_TOLERANCE);

	}

	@Test(expected = InvalidAtomException.class)
	public void atomicWeightFailTest()
	{
		Molecule a = new Molecule("A");
		assertEquals(1, a.getWeight(), DOUBLE_TOLERANCE);

		Molecule b = new Molecule("a");
		assertEquals(16, b.getWeight(), DOUBLE_TOLERANCE);

	}

	@Test
	public void compareToPosTest()
	{
		Molecule a = new Molecule("O");
		assertEquals(16, a.getWeight(), DOUBLE_TOLERANCE);

		Molecule b = new Molecule("H");
		assertEquals(1, b.getWeight(), DOUBLE_TOLERANCE);

		assertEquals(1, a.compareTo(b), DOUBLE_TOLERANCE);

	}

	@Test
	public void compareToNegTest()
	{
		Molecule a = new Molecule("O");
		assertEquals(16, a.getWeight(), DOUBLE_TOLERANCE);

		Molecule b = new Molecule("H");
		assertEquals(1, b.getWeight(), DOUBLE_TOLERANCE);

		assertEquals(-1, b.compareTo(a), DOUBLE_TOLERANCE);

	}

	@Test
	public void compareToEqualTest()
	{
		Molecule a = new Molecule("O");
		assertEquals(16, a.getWeight(), DOUBLE_TOLERANCE);

		Molecule b = new Molecule("O");
		assertEquals(16, b.getWeight(), DOUBLE_TOLERANCE);

		assertEquals(0, b.compareTo(a), DOUBLE_TOLERANCE);

	}

	@Test
	public void cloneTest()
	{
		Molecule a = new Molecule("C");
		assertEquals(12, a.getWeight(), DOUBLE_TOLERANCE);

		Object b = a.clone();

		assertNotSame(a, b);

		a.setSequence("CHO");

		assertNotEquals(a, b);

	}

	@Test
	public void parseDigitTest()
	{
		Molecule a = new Molecule("C120");

		assertEquals(1440, a.getWeight(), DOUBLE_TOLERANCE);
	}

	@Test
	public void constructorAddTest()
	{
		MoleculeCollection a = new MoleculeCollection();
		Molecule b = new Molecule("C");
		a.addMolecule(0, b);
		assertEquals(12, a.moleculeWeights());
	}

	@Test
	public void constructorNullTest()
	{
		MoleculeCollection a = new MoleculeCollection(null);
		Molecule b = new Molecule("C");
		a.addMolecule(0, b);
		assertEquals(12, a.moleculeWeights());
	}
}
