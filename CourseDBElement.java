
public class CourseDBElement implements Comparable{

	String ID;
	int CRN;
	int no_of_Credits;
	String room_no;
	String instructor;
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------Constructors
	public CourseDBElement(String id, int crn, int no_Credits, String roomno, String ins)
	{
		ID = id;
		CRN = crn;
		no_of_Credits = no_Credits;
		room_no = roomno;
		instructor = ins;
	}
	public CourseDBElement()
	{
		  ID = "";
          CRN = 0;
          no_of_Credits = 0;
          room_no = "";
          instructor = "";
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------Setters and Getters methods
	public void setID(String s)
	{
		ID = s;
	}
	public void setCRN(int i)
	{
		CRN = i;
	}
	public void setNo_of_Credits(int i)
	{
		no_of_Credits = i;
	}
	public void setRoom_no(String s)
	{
		room_no = s;
	}
	public void setInstructor(String s)
	{
		instructor = s;
	}
	public String getID ()
	{
		return ID;
	}
	public int getCRN ()
	{
		return CRN ;
	}
	public int getNo_of_Credits ()
	{
		return no_of_Credits;
	}
	public String getRoom_no ()
	{
		return room_no;
	}
	public String getInstructor ()
	{
		return instructor ;
	}
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------equals method
	public boolean equals(Object o)
	{
		 CourseDBElement temp = (CourseDBElement) o;
		if(o== null)
		{
			return false;
		}
		if(this == o)
		{
			return true;
		}
		if(CRN != temp.getCRN())
		{
			return false;
		}
		return true;
		
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	public int hashCode()
	{
		String s=CRN + ""; 
		return s.hashCode();
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------CompareTo method
	@Override
	public int compareTo(Object e) {
		int returned = this.CRN - ((CourseDBElement) e).getCRN();
		return returned;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------toString method
	public String toString()
	{
		String returned = "Course:" + ID + " CRN:" + CRN + " Credits:" + no_of_Credits + " Instructor:" + instructor + " Room:"+ room_no ;
		return returned;
	}

}
