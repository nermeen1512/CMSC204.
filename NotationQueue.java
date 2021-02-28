/**
 * This generic class has methods to deal with the queue.
 * @author Nermeen Mohi
 *
 */

import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T> {
	
	int s;
	int nodes;
	int front, rear;
	ArrayList<T> queue;
	
	//----------------------------------------------------------------Constructor with default size
	public NotationQueue()
	{
		s =30;
		nodes=0;
		front = rear = 0;
		queue = new ArrayList<T>(s);
	}
	//----------------------------------------------------------------Constructor with default size
	public NotationQueue(int c)
	{
		s = c;
		queue = new ArrayList<T>(s);
	}
	//----------------------------------------------------------------Method to check if the queue is empty
	@Override
	/**
	 * 
	 * @return boolean to indicate if queue is empty
	 */
	public boolean isEmpty()
	{
		if(nodes==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//----------------------------------------------------------------Method to check if the queue is full
	@Override
	/**
	 * 
	 * @return boolean to indicate if queue is full
	 */
	public boolean isFull()
	{
		if(nodes==s)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//----------------------------------------------------------------Method to get the element in order 
	@Override
	/**
	 * 
	 * @return T element being dequeue
	 * @throws QueueUnderflowException
	 */
	public T dequeue() throws QueueUnderflowException 
	{
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		else
		{
			front = (front+1)% s; //keep the front in place
			nodes = nodes - 1; // decrease the number of nodes
			T element = queue.get(0); //store the data at 0 in "element"
			queue.remove(0); // remove the data from the queue
			return element; // return the stored element
		}
	}
	//----------------------------------------------------------------Method to get the size of the queue
	@Override
	/**
	 * 
	 *@return int to represent the size of the queue
	 */
	public int size()
	{
		return queue.size();
	}
	//----------------------------------------------------------------Method to add the element in order 
	@Override
	/**
	 * 
	 * @return boolean to check if the element is successfully added
	 * @throws QueueOverflowException
	 */
	public boolean enqueue(T e) throws QueueOverflowException
	{
		if(isFull())
		{
			throw new QueueOverflowException();
		}
		else
		{
			queue.add(e); // add element e
			nodes= nodes +1; // increase number of nodes
			rear = (rear+1)% s; // keep the rear in place
			return true; // element e is successfully added 
		}
	}
	//----------------------------------------------------------------The toString Methods
	/**
	 * 
	 * @return String representation of the queue
	 */
	public String toString()
	{
		String output = "";
		ArrayList<T> temp = queue;   // make a copy of the queue to protect the data
		for( int i=0; i< temp.size(); i++)
		{
			output += temp.get(i).toString();
		}
		return output;
	}
	@Override
	/**
	 * 
	 * @return String representation of the queue
	 */
	public String toString(String delimiter)
	{
		String output = "";
		int s = delimiter.toString().length(); // get the size of the delimiter
		
		ArrayList<T> temp = queue;  // make a copy of the queue to protect the data
		for( int i=0; i< temp.size(); i++)
		{
			output += temp.get(i).toString() + delimiter.toString();
		}
		output = output.substring(0, (output.length()-s));
		return output;
	}
	//-------------------------------------------------------------------Method to fill in the elements in the queue
	/**
	 * 
	 * @param Arraylist of generic type T
	 */
	public void fill(ArrayList<T> list)
	{
		ArrayList<T> temp = list;
		try
		{
			for(int i=0; i<temp.size(); i++)
			{
				enqueue(temp.get(i));
			}
			queue= new ArrayList<T>(list); 
		}
		catch(QueueOverflowException x)
		{
			System.out.println(x.getMessage());
		}
		
	}

}
