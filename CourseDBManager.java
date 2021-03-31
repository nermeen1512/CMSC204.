import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	public CourseDBStructure s = new CourseDBStructure();
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) 
	{
		CourseDBElement e = new CourseDBElement( id, crn, credits, roomNum, instructor);
		s.add(e);
	}

	@Override
	public CourseDBElement get(int crn)
	{
		return s.get(crn);
	}

	/*	@Override
	public void readFile(File input) throws FileNotFoundException 
	{
		 try
		 {
             Scanner File = new Scanner(input);
             while(File.hasNext()) // as long as the file still has more courses
             {
            	 String id = File.next();
                 int crn = File.nextInt();
                 int numCredits = File.nextInt();
                 String roomNum = File.next();
                 String instructor = File.nextLine();
                 add(id, crn, numCredits, roomNum, instructor);
             }
             File.close(); //no more courses
		 }
		 catch(FileNotFoundException e) 
		 {
             System.out.print("File not found");
		 }
		
	} */

	@Override
	public void readFile(File input) throws FileNotFoundException 
	{
		Scanner in = new Scanner(input);
		String id= null;
		String StringCRN = null;
		int crn;
		String StringCredits=null;
		int credits;
		String roomNum = null;
		String instructor = null;
		Scanner line;
		while(in.hasNextLine()) //check if there is more classes in the file
		{
			line = new Scanner(in.nextLine());
			if(line.hasNext())
			{
				id = line.next();
			}
			if(line.hasNext())
			{
				StringCRN = line.next();
			}
			if(line.hasNext())
			{
				StringCredits = line.next();
			}
			if(line.hasNext())
			{
				roomNum = line.next();
			}
			if(line.hasNext())
			{
				instructor = line.next();
			}
			crn = Integer.parseInt(StringCRN); //cast to int
			credits = Integer.parseInt(StringCredits); // cast to int
			add(id, crn, credits, roomNum, instructor); // add the element read
		}
	}
	@Override
	public ArrayList<String> showAll() 
	{
		return s.showAll();
	}
}
