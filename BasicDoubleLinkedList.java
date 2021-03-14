import java.util.Iterator;
import java.util.ListIterator;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.ArrayList;


public class BasicDoubleLinkedList <T> implements Iterable<T> {

	protected int s;
	protected Node head;
	protected Node tail;
	//---------------------------------------------------------------------------------------------------Constructor
	public BasicDoubleLinkedList() 
	{
		s =0;
		head = null;
		tail = null;
	}
	//---------------------------------------------------------------------------------------------------Node class
	protected class Node
	{
		 T data;
		 Node next;
		 Node prev;
		
		public Node(T d)
		{
			data=d;
			next = prev = null;
			
		}
		public Node(T d, Node next, Node prev)
		{
			data=d;
			this.next=next;
			this.prev= prev;
		}
	}
	//---------------------------------------------------------------------------------------------------method to get the size of the list
	public int getSize() 
	{
		return s;
	}
	//---------------------------------------------------------------------------------------------------method to add element to the end of the list
	public BasicDoubleLinkedList<T> addToEnd(T data)
	{
		Node temp = new Node(data);
		if(head==null) // List is empty 
		{
			head = temp; 
			tail= head; //there is only one element
		}
		else
		{
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
		}
		s ++; // increase size of list by one(the added element)
		return this;
	}
	//---------------------------------------------------------------------------------------------------method to add element to the front of the list
	public BasicDoubleLinkedList<T> addToFront(T data)
	{
		Node temp = new Node(data);
		if(head==null) //List is empty
		{
			head = temp;
			tail=head;
		}
		else
		{
			head.prev = temp;
			temp.next = head;
			head = temp;
		}
		s++; // increase size of list by one(the added element)
		return this;
	}
	//---------------------------------------------------------------------------------------------------method to return the first element in the list
	public T getFirst()
	{
		Node temp = new Node(head.data);
		return temp.data;
	}
	//---------------------------------------------------------------------------------------------------method to return the last element in the list
	public T getLast()
	{
		Node temp = new Node(tail.data);
		return temp.data;
	}
	//---------------------------------------------------------------------------------------------------method to return the first element in the list
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException
	{
		return new LinkedListIterator();
	}
	//---------------------------------------------------------------------------------------------------method to remove the first instance of the target data in the list
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator)
	{
		Node currrentNode = head;
		Node prev = null;
		while (currrentNode != null)
		{
			if (comparator.compare(currrentNode.data, targetData) == 0) //element is found
			{
				if (currrentNode == head) // if the removed element is the first in the list
				{
					head = head.next;
					currrentNode = head;
				}
				else if (currrentNode == tail) // if the removed element is the last in the list
				{
					currrentNode = null;
					tail = prev;
					prev.next = null;
				} 
				else // if the removed element is at the middle of the list
				{
				prev.next = currrentNode.next;
				currrentNode = currrentNode.next;
				}
				s--; // decrease the size of the list one (the removed element) 
			}
			else //element is not found yet , see the next element
			{
				prev = currrentNode;
				currrentNode = currrentNode.next;
			}
		}
		return this;
	}
	//---------------------------------------------------------------------------------------------------method to remove and return the first element of the list
	public T retrieveFirstElement()
	{
		T  returned = null;
		if(s==0) // if the list is empty
		{
			return returned;
		}
		else if(head == tail) // if there is only one element in the list
		{
			returned = head.data;
			head = tail = null; // the list is empty now
			s--;
		}
		else // if there is many elements in the list
		{
			returned = head.data;
			head = head.next;
			head.prev = null;
			s--;
		}
		return returned;
	}
	//---------------------------------------------------------------------------------------------------method to remove and return the last element of the list
	public T retrieveLastElement()
	{
		T  returned = null;
		if(s==0) // if the list is empty
		{
			return returned;
		}
		else if(head == tail) // if there is only one element in the list
		{
			returned = head.data;
			head = tail = null; // the list is empty now
			s--;
		}
		else
		{
			returned = tail.data;
			
			Node currentNode = head; 
			while (currentNode.next != tail) // search for the element before the tail
			{
				currentNode = currentNode.next;
			}
			tail = null;
			tail = currentNode;
			s--;
		}
		return returned;
	}
	//---------------------------------------------------------------------------------------------------method to return an ArrayList of all items in the list from head to tail
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> returned = new ArrayList<T>();
		Node currentNode = head;
		while(currentNode != null) //there is still elements in the list
		{
			returned.add(currentNode.data); // add this element
			currentNode = currentNode.next; // go to the nest element in the list
		}
		return returned;
	}
	//---------------------------------------------------------------------------------------------------method to 
	
	public class LinkedListIterator implements ListIterator<T>
	{
		private Node current, previous;
		
		public LinkedListIterator()
		{
			current = head;
			//previous= null;
		}
		
		@Override
		public T next()
		{
			//if(current!= null)
			if(hasNext())
			{
				T returnedElement = current.data;
				previous = current;
				current = current.next;
				return returnedElement;
			}
			else
			{
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public boolean hasNext()
		{
			if(current== null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		
		@Override
		public T previous() 
		{
			Node temp;
			T returnedElement;
			if(previous != null)
			//if(hasPrevious())
			{
				temp = previous;
				previous = previous.prev;
				returnedElement = temp.data;
				return returnedElement;
			}
			else
			{
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public boolean hasPrevious()
		{
			if(previous ==null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		
		//-------------------------------------------------------------------------The other methods for ListIterator throws an exception.
		@Override
		public int nextIndex()throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public void add(T arg0)throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public int previousIndex()throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public void remove()throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();	
		}
		@Override
		public void set(T e)throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();	
		}
	}
	
	
}
