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

@SuppressWarnings("checkstyle:TodoComment")
public class MoleculeCollectionTest
{
	// Constructors

	/**
	 * Tests constructor when moleculeListIn == null.
	 */
	@Test
	public void constructorNullTest()
	{
		// Creates new empty list of Molecules.
		LinkedList<Molecule> empty = new LinkedList<>();
		MoleculeCollection coll = new MoleculeCollection(null);

		assertEquals(coll.getMoleculeList(), empty);
	}

	/**
	 * Tests specific constructor with valid input.
	 */
	@Test
	public void constructorValidTest()
	{
		LinkedList<Molecule> list = new LinkedList<>();
		Molecule a = new Molecule("C");
		list.add(a);

		MoleculeCollection coll = new MoleculeCollection(list);

		assertEquals(12, coll.moleculeWeights());
	}

	// addMolecule
	@Test
	public void addMoleculeTest()
	{
		MoleculeCollection a = new MoleculeCollection();
		Molecule b = new Molecule("C");
		a.addMolecule(0, b);
		a.addMolecule(0, null);
		assertEquals(12, a.moleculeWeights());
	}

	@Test
	public void addMoleculeOutOfRangeTest()
	{
		MoleculeCollection a = new MoleculeCollection();
		Molecule b = new Molecule("C");
		a.addMolecule(-1, b);
		assertEquals(12, a.moleculeWeights());
	}

	// sort

	// getMoleculeList
	@Test
	public void getMoleculeListTest()
	{
		MoleculeCollection coll = new MoleculeCollection();
		coll.addMolecule(0, new Molecule("C"));
		coll.addMolecule(0, new Molecule("CO2"));

		LinkedList<Molecule> expected = new LinkedList<>();
		expected.add(new Molecule("CO2"));
		expected.add(new Molecule("C"));

		assertEquals(56, coll.moleculeWeights());

	}
	// changeSequence

}
