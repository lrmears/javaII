// COURSE: CSCI1620
// TERM: SPRING 2021
// 
// NAME: Jacob Sand, Logan Mears
// RESOURCES: No outside resources were used in the creation of this class.

package molecule;

import java.util.LinkedList;


import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

/**
 * A collection of Molecules maintained in a LinkedList.
 * Allows for adding, sorting, and updating Molecules in the collection.
 * A List of the Molecules can also be retrieved;
 * the returned list is a deep copy of the list held in the MoleculeCollection.
 *
 * @author jacobsand, lmears
 */
public class MoleculeCollection
{
	//create a bunch / a few instanced variables to keep an eye / track of the last nodes
	/**
	 * Creates a linked list type Molecule.
	 */
	private LinkedList<Molecule> molecules = new LinkedList<>();

	/**
	 * Creates a new MoleculeCollection containing no Molecules yet.
	 */
	public MoleculeCollection()
	{
		this.molecules = new LinkedList<>();
	}

	/**
	 * Creates a new MoleculeCollection based upon an existing list of Molecules.
	 * The newly created MoleculeCollection will store a deep copy of the data in
	 * moleculeListIn to enforce encapsulation.
	 * If the passed reference is null, the created MoleculeCollection will be empty.
	 *
	 * @param moleculeListIn - LinkedList of Molecules used to create a new MoleculeCollection.
	 */
	public MoleculeCollection(LinkedList<Molecule> moleculeListIn)
	{
		if (moleculeListIn == null)
		{
			this.molecules = new LinkedList<Molecule>();
			return;
		}
		for (int i = 0; i < moleculeListIn.size(); i++)
		{
			Molecule gottenMol = moleculeListIn.get(i);
			molecules.add((Molecule) gottenMol.clone());
		}

	}

	/**
	 * Adds a copy of a given Molecule to this MoleculeCollection at the given index.
	 * Future external changes to the original Molecule will not impact values in the collection.
	 * If add is null, this MoleculeCollection is unchanged. If the given index is out of range,
	 * the Molecule will be added to the end of the Collection
	 *
	 * @param index - The index in which to add the Molecule
	 * @param add   - Molecule to be added to the Collection
	 */
	public void addMolecule(int index, Molecule add)
	{
		if (add == null)
		{
			return;
		}
		if (index < 0 || index >= this.molecules.size())
		{
			this.molecules.add((Molecule) add.clone());
		}
		else
		{
			this.molecules.add(index, (Molecule) add.clone());
		}
	}

	/**
	 * Reorders the MoleculeCollection based on atomic weight.
	 * Molecules with the same weights should appear in their original order of insertion
	 * relative to one another (ie., sort() is a stable sorting algorithm).
	 */
	
	public void sort()
	{
		sortHelper(this.molecules, 0, this.molecules.size() - 1);
	}
	/**
	 * Recursive Helper for sort.
	 * @param moleculecollection2 the moleculeCollection being passed.
	 * @param left Lower Index of the subArray
	 * @param right Upper Index of the subArray
	 */
	public void sortHelper(LinkedList<Molecule> moleculecollection2, int left, int right)
	{
		if ((right - left) > 1)	
		{
			int middle = left + (right - left) / 2;
			
			sortHelper(moleculecollection2, left, middle);
			sortHelper(moleculecollection2, middle + 1, right);

			merge(moleculecollection2, left, middle, right);
		}
	}
	/**
	 * Helper method for sort, merges the 2 subarrays.
	 * @param moleculecollection2 the moleculeCollection being passed.s
	 * @param left Lower index of first sub-array.
	 * @param middle Upper index of first sub-array.
	 * @param right Upper index of second sub-array.
	 */
	public void merge(LinkedList<Molecule> moleculecollection2, int left, int middle,  int right)
	{
		int leftIndex = middle - left + 1;
		int rightIndex = right - middle;
		
		
		LinkedList<Molecule> combinedLeft = new LinkedList<Molecule>();
		LinkedList<Molecule> combinedRight = new LinkedList<Molecule>();
		
		for (int i = 0; i < leftIndex; i++)
		{
			combinedLeft.add(this.molecules.get(left + i));
		}
		for (int j = 0; j < rightIndex; j++)
		{
			combinedRight.add(this.molecules.get(middle + 1 + j));
		}
		this.molecules.clear();
		//System.out.print(combinedLeft);
		//System.out.print(combinedRight);
		int leftIndexSub = 0, rightIndexSub = 0;
		int combinedIndex = 0;
		while (leftIndexSub < leftIndex && rightIndexSub < rightIndex)
		{
			if (combinedLeft.get(leftIndexSub).getWeight() 
					< combinedRight.get(rightIndexSub).getWeight())
			{
				this.molecules.add(combinedLeft.get(leftIndexSub));
				leftIndexSub++;
			}
			else 
			{
				this.molecules.add(combinedRight.get(rightIndexSub));
				rightIndexSub++;
			}
			combinedIndex++;
		}
		while (leftIndexSub < leftIndex)
		{
			this.molecules.add(combinedIndex++, combinedLeft.get(leftIndexSub));
			leftIndexSub++;
		}
		while (rightIndexSub < rightIndex)
		{
			this.molecules.add(combinedIndex++, combinedRight.get(rightIndexSub));
			rightIndexSub++;
		}
		// As long as both subarray pieces have data still in them, 
				// we need to keep picking the next smallest from the start
				// of each and putting it into combined
		/*while (leftIndex <= middle && rightIndex <= right)
		{
			// Is the first item of the left subarray smalleb r?
			if (this.molecules.get(leftIndex).getWeight() 
					< this.molecules.get(rightIndex).getWeight())
			{
				combined.add(combinedIndex++, this.molecules.get(leftIndex++));
			}
			// Or is the first item in the right one smaller?
			else 
			{
				combined.add(combinedIndex++, this.molecules.get(rightIndex++));
			}
		}
		// If the left sub-array has run out of values, we need
		// to go through emptying the remainder from the right
		if (leftIndex == middle)
		{
			while (rightIndex <= right)
			{
				combined.add(combinedIndex++, this.molecules.get(rightIndex++));
				//combined[combinedIndex++] = data[rightIndex++];
			}
		}
		else
		{
			while (leftIndex <= middle)
			{
				combined.add(combinedIndex++, this.molecules.get(leftIndex++));
			}
		}
		//finally copy array
		this.molecules.clear();
		for (int i = left; i <= right; i++)
		{
			this.molecules.add(combined.get(i));	
		} */
	}
	/**
	 * Sums the weights of all Molecules in the MoleculeCollection.
	 *
	 * @return The sum of all weights in the collection.
	 */
	public int moleculeWeights()
	{
		int sum = 0;
		for (int i = 0; i < this.molecules.size(); i++)
		{
			Molecule gottenMol = this.molecules.get(i);
			sum += gottenMol.getWeight();
		}
		return sum;
	}

	/**
	 * Generates and returns a deep copy of a list containing all of the Molecules in this MoleculeCollection.
	 * Modifying the returned list will not impact the contents of this MoleculeCollection in any way.
	 *
	 * @return Deep copy of the Molecules
	 */
	public LinkedList<Molecule> getMoleculeList()
	{
		LinkedList<Molecule> copiedList = new LinkedList<>();
		for (int i = 0; i < this.molecules.size(); i++)
		{
			Molecule gottenMol = this.molecules.get(i);
			copiedList.add((Molecule) gottenMol.clone());
		}
		return copiedList;
	}

	/**
	 * Changes the sequence of a Molecule in the collection at the specified index.
	 * This does not create a new Molecule, rather modifies an existing Molecule.
	 * If the provided sequence is not valid due to either an invalid sequence or an invalid atom,
	 * the original state of the Molecule at the specified index should be unaffected and
	 * the resulting exception will be thrown to the caller.
	 *
	 * @param index       - Location of the Molecule to update
	 * @param newSequence - New sequence of the specified Molecule
	 * @throws InvalidAtomException     - Thrown if the new sequence is invalid due to unknown atom
	 * @throws InvalidSequenceException - Thrown if the new sequence is invalid due to format
	 */
	public void changeSequence(int index, String newSequence) throws InvalidAtomException, InvalidSequenceException
	{
		if (index < 0 || index >= this.molecules.size())
		{
			return;
		}

		Molecule gottenMol = this.molecules.get(index);
		gottenMol.setSequence(newSequence);
	}

}
