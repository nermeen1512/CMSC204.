import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	protected Comparator<T> comparator;
	//---------------------------------------------------------------------------------------------constructor
	public SortedDoubleLinkedList(Comparator<T> comparator2)
	{
		comparator = comparator2;
		//initiation for the parent class
		s=0;
		head = tail = null;
	}
	//----------------------------------------------------------------------------------------------method to add a specific element in the right sorted place in the sorted list
	public SortedDoubleLinkedList<T> add(T data)
	{
		Node temp = new Node(data, null, null);
		
		if (head == null) //if the list is empty //if(s==0)
		{
			head = tail = temp;
		} 
		else // if list isn't empty
		{
			if (comparator.compare(data, head.data) <= 0) //add to the front of the list
			{
				temp.next = head;
				head = temp;
			} 
			else if (comparator.compare(data, tail.data) >= 0) //add to the end of the list
			{
				tail.next = temp;
				tail = temp;
			} 
			else // add to the middle of the list
			{
				Node following = head.next;
				Node prev = head;
				while (comparator.compare(data, following.data) > 0) //loop on the elements of the list
				{
				prev = following;
				following = following.next;
				}
				prev.next = temp;
				temp.next = following;
			}
		}
		s++;
		return this;
	}
	//----------------------------------------------------------------------------------------------addToFront & addToEnd methods are unsupported
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	//----------------------------------------------------------------------------------------------a method that return an iterator positioned at the head of the list
	public ListIterator<T> iterator() 
	{
		return new LinkedListIterator();
	}
	//----------------------------------------------------------------------------------------------a method to remove a specific element
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator)
	{
		Node following = head;
		Node prev = null;
		while (following != null)
		{
			if (comparator.compare(following.data, data) == 0) 
			{
				s--;
				if (prev != null) {
				prev.next = following.next;
				} else {
				head = following.next;
				}
				if (following == tail) {
				tail = prev;
				}
			}
			
			prev = following;
			following = following.next;
		}

		return this;
	}
	//----------------------------------------------------------------------------------------------a toArrayList method
	/* 
	 public ArrayList<T> toArrayLList()
	 {
	 	ArrayList<T> returned = new ArrayList<T>():
	 	Node current = head;
	 	while(current != null)
	 	{
	 		returned.add(current.data);
	 		current = current.next;
	 	}
	 	return returned;
	 }
 */

}
