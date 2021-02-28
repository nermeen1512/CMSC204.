/**
 * This generic class has methods to deal with the stack.
 * @author Nermeen Mohi
 *
 */

import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T>{
	 int s;
	 int top;
	 ArrayList<T> stack;
	 
	
	//-------------------------------------------------------------------The constructor with default size
	public NotationStack()
	{
		s= 30;
		top= -1;
		stack = new ArrayList<T>(s);
	}
	//-------------------------------------------------------------------The constructor with customized size
	public NotationStack(int s1)
	{
		s = s1;
		top= -1;
		stack = new ArrayList<T>(s);
	}
	//-------------------------------------------------------------------Method to check if the stack is empty
	@Override
	/**
	 * 
	 * @return boolean to indicate if stack is empty
	 */
	public boolean isEmpty() 
	{
		if(top == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//-------------------------------------------------------------------Method to check if the stack is full
	@Override
	/**
	 * 
	 * @return boolean to indicate if stack is full
	 */
	public boolean isFull() 
	{	
		if(top==(s-1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//-------------------------------------------------------------------Method to return the element in the top
	@Override
	/**
	 * 
	 * @return T element being removed
	 * @throws StackUnderflowException
	 */
	public T pop() throws StackUnderflowException
	{
		int temp;
		if(top == -1)
		{
			throw new StackUnderflowException();
		}
		else
		{
			temp = top; //store the index of the top
			top = top -1; // decrease the original top 
			T element = stack.get(temp); // store the top element
			stack.remove(temp); // delete the element from the stack
			return element; // return the value of the element
			
		}
	}

	@Override
	/**
	 * 
	 * @return T element at the top of the stack
	 * @throws StackUnderflowException
	 */
	public T top() throws StackUnderflowException 
	{
		
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			T element = stack.get(top);
			return element;
		}
	}
	//-------------------------------------------------------------------Method to return the number of elements in the stack
	@Override
	/**
	 * 
	 *@return int to represent the size of the queue
	 */
	public int size()
	{
		 return (top+1);   
	}

	@Override
	/**
	 * 
	 * @return boolean to check if the element is successfully added
	 * @throws StackOverflowException
	 */
	public boolean push(T e) throws StackOverflowException 
	{		
		if(isFull()) // check if the stack is full 
		{
			throw new StackOverflowException();
		}
		else
		{
			top = top+1; // increase the element
			stack.add(top,e); // add the element in the top
			return true; // the element was pushed successfully
		}	
	}
	//-------------------------------------------------------------------The toString Methods
	/**
	 * 
	 * @return String representation of the stack
	 */
	public String toString()
	{
		String output = "";
		ArrayList<T> temp = stack;   // make a copy of the queue to protect the data
		for( int i=0; i< temp.size(); i++)
		{
			output += temp.get(i).toString();
		}
		return output;
	}
	@Override
	/**
	 * 
	 * @return String representation of the stack
	 */
	public String toString(String delimiter) 
	{
		String output = "";
		int s = delimiter.toString().length(); // get the size of the delimiter
		
		ArrayList<T> temp = stack;  // make a copy of the queue to protect the data
		for( int i=0; i< temp.size(); i++)
		{
			output += temp.get(i).toString() + delimiter.toString();
		}
		output = output.substring(0, (output.length()-s));
		return output;
	}
	//-------------------------------------------------------------------Method to fill in the elements in the stack
	@Override
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
				push(temp.get(i));
			}
			stack= new ArrayList<T>(list); 
		}
		catch(StackOverflowException x)
		{
			System.out.println(x.getMessage());
		}
		
	}

}
