// COURSE: CSCI1620
// TERM: Spring 2021
//
// NAME: Logan Mears
// RESOURCES: Starter code provided.

package uno.collections.lists;

/**
 * This class is a specialized form of linked list that maintains sorted order for all inserted items.
 */
public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E>
{
	private ListNode<E> head;

	/**
	 * Creates a new empty SortedLinkedList.
	 */
	public SortedLinkedList()
	{
		head = null;
	}

	/**
	 * Adds the specified item to the list while preserving the global sorted order of the list.
	 * This method guarantees no worse than linear runtime performance for each add operation.
	 *
	 * @param item - The new item to be inserted.
	 * @return true when the item was successfully added (which is always)
	 */
	@Override
	public boolean add(E item)
	{
		ListNode<E> newNode = new ListNode<E>(item, null);
		if (head == null)
		{
			head = newNode;
		}
		else if (item.compareTo(head.getData()) < 0)
		{
			newNode.setNext(head);
			head = newNode;
		}
		else
		{
			ListNode<E> before = head.getNext();
			ListNode<E> after = head;

			while (after != null)
			{
				if (item.compareTo(after.getData()) < 0)
				{
					break;
				}
				before = after;
				after = after.getNext();
			}
			newNode.setNext(before.getNext());
			before.setNext(newNode);
		}


		return true;
	}

	/**
	 * This method is disallowed for SortedLinkedLists. All calls will result in an exception.
	 *
	 * @param index - The index where an item is to be added in the list.
	 * @param item  - The item to be added to the list.
	 * @throws UnsupportedOperationException - is thrown any time this method gets called as it would
	 *                                       violate sorted ordering requirements of SortedLinkedList.
	 */
	public void add(int index, E item) throws UnsupportedOperationException
	{
		try
		{
			throw new UnsupportedOperationException("Unsupported operation!");
		}
		catch (UnsupportedOperationException e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is disallowed for SortedLinkedLists. All calls will result in an exception.
	 *
	 * @param index - The index where an item is to be added in the list.
	 * @param item  - The item to be added to the list.
	 * @return the element previously stored at the specified index.
	 * @throws UnsupportedOperationException - is thrown any time this method gets called as it would
	 *                                       violate sorted ordering requirements of SortedLinkedList.
	 */
	public E set(int index, E item) throws UnsupportedOperationException
	{
		try
		{
			throw new UnsupportedOperationException("Unsupported operation!");
		}
		catch (UnsupportedOperationException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
}
