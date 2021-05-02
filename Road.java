/**
* A class Road that can represent the edges of a Graph of Towns.
*  @author Nermeen Mohi
*/

public class Road implements Comparable<Road>
{
	Town t1, t2; //two endpoints
	String name;
	int d;
	
	/**
	* A constructor
	* @param  t1 First town
	* @param  t2 Last town
	* @param  Weight of the edge
	* @param  Name of the road
	*/
	public Road(Town tt1, Town tt2, int dd, String n)
	{
	   t1 = tt1;
	   t2 = tt2;
	   d = dd;
	   name = n;
	}
	
	/**
	* Constructor with weight preset at 1,
	* @param t1 One town on the road
	* @param t2 Another town on the road
	* @param name name of the road
	*/
	public Road(Town t1, Town t2, String name) {
	   this.t1 = t1;
	   this.t2 = t2;
	   this.name = name;
	   this.d = 1;
	     
	}
	
	//----------------------------------------------------------------------------------Setters and getters
	/**
	* A method to return the first town on the road
	* @return a town on the road
	*/
	public Town getT1()
	{
	   return t1;
	}
	
	/**
	* A method to return the last town on the road
	* @return another town on the road
	*/
	public Town getT2()
	{
	   return t2;
	}
	
	/**
	* A method to return the road name
	* @return the road name
	*/
	public String getName()
	{
	   return name;
	}
	
	/**
	* A method to return the distance of the road
	* @return distance of the road
	*/
	public int getD() 
	{
	   return d;
	}
	
	
	/**
	* A method to set the first town on the road
	* @param Town t1 a town on the road
	*/
	public void setT1(Town tt1)
	{
	   t1 = tt1;
	}
	
	/**
	*A method to set the last town on the road
	* @param Town t2 another town on the road
	*/
	public void setT2(Town tt2) 
	{
	   t2 = tt2;
	}
	
	/**
	* A method to set the road name
	* @param String : name of the road
	*/
	public void setName(String n)
	{
	   name = n;
	}
	
	/**
	* A method to set the distance of the road
	* @param int : distance of the road
	*/
	public void setD(int dd) 
	{
	   this.d = dd;
	}
	
	//---------------------------------------------------------------------------- A method to check if the road contains a certain town
	/**
	* A method to check if the road contains a certain town 
	* @param Town : t
	* @return Boolean : b
	*/
	public boolean contains(Town t)
	{
	   return (t1.compareTo(t) == 0 || t2.compareTo(t) == 0); 
	}
	
	//-----------------------------------------------------------------------------------------------------Methods to compare between two roads:
	/**
	* A compareTo method 
	* @return int : i (0 if the roads' names are the same)
	*/
	public int compareTo(Road r)
	{
	   if (d> r.d)
	   {
		   return 1;
	   }
	   if (d< r.d) 
	   {
		   return -1;
	   }
	   return 0; //EQUALS
	}
	
	/**
	* A method that returns true if each of the ends of the road r is the same as the ends of this road.
	* @param Object road to compare it to
	* @return Boolean : b
	*/
	@Override
	public boolean equals(Object o)
	{
	   if (o == this) 
	   {
		   return true;
	   }
	   Road r = (Road) o; // casting
	 
	   return (t1.equals(r.t1) || t1.equals(r.t2)) && (t2.equals(r.t2) || t2.equals(r.t1)); //4 cases
	}
	
	//-----------------------------------------------------------------------------------------------------A method to print out a string representation of the road:
	/**
	* toString method
	* @return String s
	*/
	@Override
	public String toString()
	{
		return "The Road name is: " + name + " of distance = " + d;
	}
}