// COURSE: CSCI1620
// TERM: SPRING 2021
// 
// NAME: Jacob Sand, Logan Mears
// RESOURCES: No outside resources were used in the creation of this class.

package molecule;

import java.util.Stack;

import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;


/**
 * Objects of the Molecule class represent a single chemical molecule made up of any number
 * of ATOMIC_WEIGHT_HYDROGEN, ATOMIC_WEIGHT_CARBON, and ATOMIC_WEIGHT_OXYGEN atoms.
 * The class provides functionality to compute the atomic weight of the molecule.
 *
 * @author jacobsand, lmears
 */
public class Molecule implements Comparable<Molecule>, Cloneable
{

	/**
	 * Variable for ATOMIC_WEIGHT_HYDROGEN weight.
	 */
	private static final int ATOMIC_WEIGHT_HYDROGEN = 1;
	/**
	 * Variable for ATOMIC_WEIGHT_CARBON weight.
	 */
	private static final int ATOMIC_WEIGHT_CARBON = 12;
	/**
	 * Variable for ATOMIC_WEIGHT_OXYGEN weight.
	 */
	private static final int ATOMIC_WEIGHT_OXYGEN = 16;
	/**
	 * A default value for tracking the weight of an atom.
	 */
	private int weight;
	/**
	 * A global sequence string. 
	 */
	private String sequence; //likely don't need

	/**
	 * Creates a new Molecule made up of the H, C, and O atoms in the configuration specified by sequenceIn.
	 *
	 * @param sequenceIn - The sequence of atoms for this Molecule.
	 * @throws InvalidAtomException     - if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException - if unmatched parentheses exist in sequenceIn or
	 *                                  incoming sequence is null or empty String.
	 */
	public Molecule(String sequenceIn)
	{
		this.weight = parseSequence(sequenceIn);
		this.sequence = sequenceIn;
	}


	/**
	 * Updates the sequence of atoms represented by this Molecule.
	 *
	 * @param sequenceIn - The new molecular sequence to be used for this Molecule.
	 * @throws InvalidAtomException     - if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException - if unmatched parentheses exist in sequenceIn
	 */
	public void setSequence(String sequenceIn)
	{
		this.weight = parseSequence(sequenceIn);
		this.sequence = sequenceIn;
	}

	/**
	 * Private method used to parse the given string.
	 *
	 * @return finalPop - an int with the final Value
	 * @param sequenceIn - instanced/local variable
	 * @throws InvalidAtomException     - if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException - if unmatched parentheses exist in sequenceI
	 */
	private int parseSequence(String sequenceIn) throws InvalidAtomException, InvalidSequenceException
	{

		Stack<Integer> moleculeCounter = new Stack<Integer>();

		String seq = "(" + sequenceIn + ")";

		int index = 0;

		while (index < seq.length())
		{
			char currentEval = seq.charAt(index);
			if (currentEval == '(')
			{
				moleculeCounter.push(-1);
			}
			else if (currentEval == ')')
			{
				int poppedValue = 0, stackSum = 0;
				while (poppedValue != -1)
				{
					poppedValue = moleculeCounter.pop();
					if (poppedValue == -1)
					{
						moleculeCounter.push(stackSum);
					}
					else
					{
						stackSum += poppedValue;
					}
				}

			}
			else if (Character.isDigit(currentEval))
			{
				String digits = "" + currentEval;
				
				while ((index + 1) < seq.length() && Character.isDigit(seq.charAt(index + 1)))
				{
					digits += seq.charAt(index + 1);
					index++;
					
				}
				int num = Integer.parseInt(digits); 
				int poppedVal = moleculeCounter.pop();
				int pushMC = poppedVal * num;
				moleculeCounter.push(pushMC);

			}
			else
			{
				moleculeCounter.push(Molecule.atomWeight(currentEval));
			}
			index++;
		}
		int finalPop = moleculeCounter.pop();
		
		if (!moleculeCounter.empty())
		{
			throw new InvalidSequenceException();
		}
		
		return finalPop;

	}

	/**
	 * Retrieves a String containing this Molecule's sequence of atoms.
	 *
	 * @return Molecular sequence of the Molecule.
	 */
	public String getSequence()
	{
		return this.sequence;
	}

	/**
	 * Retrieves this Molecule's weight, which is calculated based on the Molecule's sequence
	 * per the algorithm specified.
	 *
	 * @return Weight of the Molecule.
	 */
	public int getWeight()
	{
		return this.weight;
	}

	/**
	 * Generates and returns a String with the Molecule's sequence and weight. The format of the String is
	 * <p>
	 * [SEQUENCE               ]: WEIGHT
	 * <p>
	 * Where SEQUENCE has a field width of 25 and is left justified
	 * (square brackets are just placeholders and will not appear in actual return values).
	 * WEIGHT should be left-justified. There is no space following the SEQUENCE field and the colon.
	 *
	 * @return The generated String.
	 */
	@Override
	public String toString()
	{
		return String.format("%-25s: %d", this.getSequence(), this.getWeight());
	}

	/**
	 * Static utility method to return the atomic weight of a given atom.
	 * Supported atoms are ATOMIC_WEIGHT_CARBON (C), ATOMIC_WEIGHT_HYDROGEN (H), and ATOMIC_WEIGHT_OXYGEN (O),
	 * and the value of the atom parameter
	 * corresponds to the single letter abbreviation for these atoms (case insensitive).
	 * Atomic weights are given in their nearest whole number:
	 * HYDROGEN - 1
	 * CARBON - 12
	 * OXYGEN - 16
	 *
	 * @param atom - Character for atom abbreviation
	 * @return Atomic weight of passed atom
	 * @throws molecule.exceptions.InvalidAtomException - Thrown if an unsupported atom is passed
	 */
	public static int atomWeight(char atom) throws InvalidAtomException
	{
		int weight = -1;
		switch (atom)
		{
			case 'C':
			case 'c':
				weight = ATOMIC_WEIGHT_CARBON;
				break;
			case 'O':
			case 'o':
				weight = ATOMIC_WEIGHT_OXYGEN;
				break;
			case 'H':
			case 'h':
				weight = ATOMIC_WEIGHT_HYDROGEN;
				break;
			default:
				throw new InvalidAtomException(atom);
		}
		return weight;
	}

	/**
	 * Compares this Molecule to a passed Molecule, determining natural order.
	 * Molecules with the same weight (regardless of sequence) are considered equal.
	 * All others are ordered relative to the magnitude of their weights.
	 *
	 * @param other - Incoming Molecule to be compared with this (local) Molecule.
	 * @return Returns an int less than 0 if the local Molecule is less than the passed Molecule,
	 * an int greater than 0 if the local Molecule is greater than the passed Molecule,
	 * and a 0 if the Molecules are equal.
	 */
	public int compareTo(Molecule other)
	{
		// the this.value used in the comparison is a placeholder
		int compareVal = 1;
		if (this.weight < other.getWeight())
		{
			compareVal = -1;
		} 
		else if (this.weight == other.getWeight())
		{
			compareVal = 0;	
		}
		return compareVal;
	}

	/**
	 * Returns a deep copy of the Molecule.
	 * The reference returned should refer to a completely separate molecule with no direct or
	 * indirect aliasing of any instance data in the original Molecule.
	 * NOTE: This method should NOT throw a CloneNotSupportedException.
	 *
	 * @return Deep copy of the calling Molecule.
	 */
	@Override
	public Object clone()
	{
		try
		{
			Molecule cloned = (Molecule) super.clone();
			cloned.setSequence(this.sequence);
			return cloned;
		}
		catch (CloneNotSupportedException a)
		{
			throw new RuntimeException();
		}
	}

}
