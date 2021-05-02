
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
* A Graph class that will hold an object of your Graph. Implement the TownGraphManagerInterface. There are methods to populate the graph
*  @author Nermeen Mohi
*/
public class TownGraphManager implements TownGraphManagerInterface
{
	
	Graph graph;
	 
	//----------------------------------------------constructor
	/**
	*A constructor
	*/
	public TownGraphManager()
	{
	   graph = new Graph();
	}
	
	//-----------------------------------------------------------------------------------------A method to add a element to the graph
	/**
	* A method to adds a road given 2 towns and a road name
	* @param String : name of town 1
	* @param String : name of town 2
	* @param String : name of road
	* @param  Int : weight road length
	* @return Boolean b : (true if the road was added successfully)
	*/
	@Override
	public boolean addRoad(String t1, String t2, int weight, String roadName)
	{
		boolean returned = (graph.addEdge(new Town(t1), new Town(t2), weight, roadName)) != null;
		return returned;
	}
	
	/**
	*A method to add a town to the graph
	* @param String : v the town's name
	* @return Boolean b : true if the town was successfully added, false if not
	*/
	@Override
	public boolean addTown(String v) 
	{
		boolean returned = graph.addVertex(new Town(v));
		return returned;
	}
	
	//-----------------------------------------------------------------------------------------A method to get a road
	/**
	*  A method to return the name of the road that connect wo towns
	* @param String : name of town 1
	* @param String : name of town 2
	* @return name of road if town 1 and town2 are in the same road
	*/
	@Override
	public String getRoad(String town1, String town2)
	{
	Road r = graph.getEdge(new Town(town1), new Town(town2));
	
	return r.getName();
	}
	  
	/**
   * GA method to gets a town given its name
   * @param String : the town's name
   * @return the Town specified by the name
   */
    public Town getTown(String name) 
    {
        Town returned = null;
		for (Town t : graph.vertexSet()) 
		{
			if (t.getName().equals(name))
			{
				returned = t;
			}
		}
		return returned;
	}

    
	/**
	* Determines if a town is already in the graph
	* @param v the town's name
	* @return true if the town is in the graph, false if not
	*/
	@Override
	public boolean containsTown(String v)
	{
		boolean returned = graph.containsVertex(new Town(v));
		return returned;
	}
	
	/**
	* A method to determine if a road is in the graph
	* @param String: name of town 1
	* @param String : name of town 2
	* @return Boolean b : (true if the road is in the graph)
	*/
	@Override
	public boolean containsRoadConnection(String town1, String town2) 
	{
		boolean returned = graph.containsEdge(new Town(town1), new Town(town2));
		return returned;
	}
	
	//------------------------------------------------------------------------------------Array list for all elements
	/**
	* A method that return an arraylist of all roads in sorted order
	* @return an arraylist
	*/
	@Override
	public ArrayList<String> allRoads() 
	{
		ArrayList<String> returned = new ArrayList<>();
		
		for (Road r : graph.edgeSet())
		{
			if (!returned.contains(r.getName()))
			{
				returned.add(r.getName());
			}
		}
		Collections.sort(returned);
		return returned;
	}
	
	/**
	* Method that returns an arraylist of all towns in alphabetical order 
	* @return an arraylist 
	*/
	@Override
	public ArrayList<String> allTowns() 
	{
		ArrayList<String> returned = new ArrayList<>();
	
		for (Town t : graph.vertexSet()) 
		{
			if (!returned.contains(t.getName()))
			{
				returned.add(t.getName());
			}
		}
		Collections.sort(returned);
		return returned;
	}
	
	
	//--------------------------------------------------------------methods to delete an element from the graph
	/**
	* A method that deletes a road from the graph
	* @param String : name of town 1
	* @param String : name of town 2
	* @param String : the road name
	* @return Boolean : true if the road was successfully deleted
	*/
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road)
	{
		boolean returned = graph.removeEdge(new Town(town1), new Town(town2), 1, road) != null;
		return returned;
	}
	
	/**
	* A method that deletes a town from the graph
	* @param v name of town
	* @return true if the town was successfully deleted, false if not
	*/
	@Override
	public boolean deleteTown(String v)
	{
		boolean returned = graph.removeVertex(new Town(v));
		return returned;
	}
	
	/**
	* A method that returns the shortest path from town 1 to town 2
	*
	* @param town1 name of town 1
	* @param town2 name of town 2
	* @return an Arraylist of roads connecting the two towns together, null if
	* the towns have no path to connect them.
	*/
	@Override
	public ArrayList<String> getPath(String town1, String town2)
	{
		return graph.shortestPath(new Town(town1), new Town(town2));
	}
	
	public void populateTownGraph(File selectedFile) throws FileNotFoundException
	{
		// TODO Auto-generated method stub
		
	}
 
}