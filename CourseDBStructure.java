import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	public int size;
	public String name;
	public LinkedList<CourseDBElement> hashTable[];
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------Constructors
	 /**
     * Constructor
     * @param size
     */
	public CourseDBStructure(int n)
	{
		size = n;
		hashTable = new LinkedList[size];
	}
	
	 /**
     * Default Constructor
     * @param size
     */
	public CourseDBStructure()
	{
		size = 20; // I used 20 as a default size
		hashTable = new LinkedList[size];
	}
	
	
	 /**
     * Testing Constructor
     * @param size
     */
	public CourseDBStructure(String s, int n)
	{
		size = 20; // I used 20 as a default size
		hashTable = new LinkedList[size];
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------method to add an element
	 /**
     * Method that takes a CourseDBElement object and adds it to the hashtable.
     * @param element
     */
	@Override
	public void add(CourseDBElement element) 
	{
		int i = element.hashCode() % size;
        if(hashTable[i] == null) //check if its null creates new linkedlist
        {
        	hashTable[i] = new LinkedList<CourseDBElement>();
        }
        hashTable[i].add(element);
	}

	
	//----------------------------------------------------------------------------------------------------------------------------------------------------method to get an element giving its CRN
	/**
     * Method that gets the CourseDBElement object given its CRN.
     * @param crn
     * @return CourseDBElement e
     */
	@Override
	public CourseDBElement get(int crn)
	{
		String s = crn+"";
		int i= s.hashCode() % size;
		for(int j=0;i< size;j++) //loop on all the elements
		{
			CourseDBElement temp = hashTable[i].get(i);
			if(temp.getCRN()== crn) // if the crn id found
			{
				return temp;
			}
		}
		return null; //if the crn isn't found
	}
	//----------------------------------------------------------------------------------------------------------------------------------------------------method to get the size of the hashTable
	 /**
     * Method that returns the size of the hash Table.
     * @return size
     */
	@Override
	public int getTableSize()
	{
		return size;
	}

	public ArrayList<String> showAll()
	{
		ArrayList<String> returned = new ArrayList<String>();
		for(int i=0; i< getTableSize(); i++)
		{
			if(hashTable[i] != null)
			{
				LinkedList<CourseDBElement> temp = hashTable[i];
				for(CourseDBElement e: temp)
				{
					
					String s="\n"+ e;
					returned.add(s);
				}
			}
		}
		return returned;
	}
}























