
/**
* A Class that holds the name of the town and a list of adjacent towns
*  @author Nermeen Mohi
*/


import java.util.*;


public class Town implements Comparable<Town>
{
   private String name;
   private Town adj;
  
   //----------------------------------------------------------------------------------The constructor
   /**
   *A constructor that initialize the name of the town
   * @param Name
   */
   public Town(String name)
   {
       this.name = name;
   }
   
   /**
   *A copy constructor
   * @param Town t
   */
   public Town(Town t)
   {
	   setAdj(t);
   }
  
  
   //----------------------------------------------------------------------------------Setters and getters
  /**
   * A method to get the town's name
   * @return String : town's name
   */
   public String getName()
   {
       return name;
   }
   
   /**
   * get the addjacent town
   * @return Town t
   */
   public Town getAdj() 
   {
       return adj;
   }

  /**
   * set town's name
   * @param name town's name
   */
   public void setName(String n)
   {
       name = n;
   }
   
   /**
   * set template town
   * @param templateTown
   */
   public void setAdj(Town t)
   {
       adj = t;
   }

   //------------------------------------------------------------------------------------------------------Methods to compare between two towns
   /**
   *A CompareTo method to see if two towns are equal ( have the same name)
   * @return Int i : 0 if htey are the same
   */
   public int compareTo(Town o)
   {
       return name.compareTo(o.name);
   }
   
   /**
   *@return true if the town names are equal, false if not
   */
   @Override
   public boolean equals(Object obj)
   {
       Town town = (Town)obj; //casting 
       boolean returned = name.compareTo(town.name) == 0;
       return returned;
   }

   //------------------------------------------------------------------------------------------------------A method to print out a string representation of the town:
   /**
   * to string method
   * @return the town name
   */
   public String toString()
   {
	   return "Town's name is : " + name;
   }

   //------------------------------------------------------------------------------------------------------A method to print out the hashcode for the name
   /**
   * @return the hashcode for the name of the town
   */
   @Override
   public int hashCode()
   {
	   int returned= name.hashCode(); 
	   return returned;
   }
   
}
