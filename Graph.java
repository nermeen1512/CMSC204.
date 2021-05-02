

/**
* A Graph class that implements the GraphInterface given to store the graph, use an adjacent matrix or an adjacency list
*  @author Nermeen Mohi
*/


import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> 
{

	 Set<Town> towns;
	 Set<Road> roads;
	 Map<String, Town> previousTown;
	 
	//-------------------------------------------------------------------------------------------------------A constructor
	/**
	* A constructor to set the graph
	*/
	public Graph()
	{
	   towns = new HashSet<>();
	   roads = new HashSet<>();
	   previousTown = new HashMap<>();
	}
	
	//------------------------------------------------------------------------------------------------------Setters and Getters
	/**
	* A method to return a certain edge connecting source vertex to destination vertex
	* @param Town : source vertex of the edge
	* @param Town : destination vertex of the edge
	* @return Road : an edge connecting source vertex to target vertex
	*/
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex)
	{
		Road returned= null; 
		for (Road r : roads)
		{
			if ((sourceVertex.equals(r.getT1()) || sourceVertex.equals(r.getT2())) && (destinationVertex.equals(r.getT2()) || destinationVertex.equals(r.getT1()))) 
			{
				returned = r;
			}
		}
		return returned;
	}
	
	/**
	* A method to create a new edge
	* @param Town : sourceVertex
	* @param Town : destinationVertex 
	* @param Int : distance ( weight)
	* @param String : name (description) 
	* @return The newly created edge if added to the graph, otherwise null.
	* @throws IllegalArgumentException if source or target vertices are not found in the graph.
	* @throws NullPointerException if any of the specified vertices is null.
	*/
	
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
	{
		Road r = new Road(sourceVertex, destinationVertex, weight, description);
		
	   if (containsEdge(sourceVertex, destinationVertex)) 
	   {
		   return null;
	   }
	   if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) 
	   {
		   throw new IllegalArgumentException();
	   }
	   if (sourceVertex == null || destinationVertex == null || description == null) 
	   {
		   throw new NullPointerException();
	   }
	   
	   roads.add(r);
	   return r;
	  
	}
	
	/**
	* A  method to adds the specified vertex to the graph 
	* @param Town : v vertex to be added to this graph.
	* @return Boolean : b (true if this graph did not already contain the specified vertex.)
	* @throws NullPointerException if the specified vertex is null.
	*/
	@Override
	public boolean addVertex(Town v)
	{
		towns.add(v);
		
		if (v == null) 
		{
			throw new NullPointerException();
		}
		
		if (containsVertex(v)) 
		{
			return false;
		}
		return true;
	}
	
	//------------------------------------------------------------------------------------------------------Method to check on components of the graph
	/**
	* A method to check if a graph contains an edge 
	* @param Town : sourceVertex 
	* @param Town : destinationVertex 
	* @return true if this graph contains the specified edge
	*/
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex)
	{
		for (Road r : roads)
		{
			if ((sourceVertex.equals(r.getT1()) || sourceVertex.equals(r.getT2())) && (destinationVertex.equals(r.getT2()) || destinationVertex.equals(r.getT1()))) 
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	* A method to check if this graph contains the specified vertex 
	* @param Town : v vertex whose presence in this graph is to be tested
	* @return Boolean : b (true if this graph contains the specified vertex)
	*/
	@Override
	public boolean containsVertex(Town v)
	{
		for (Town t : towns)
		{
			if (t.equals(v)) 
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	* A method that returns a set of the edges contained in this graph
	* @return a set of the edges contained in this graph
	*/
	@Override
	public Set<Road> edgeSet() 
	{
		return roads;
	}
	
	/**
	* A method to return a set of the vertices contained in the graph
	* @return a set view of the vertices contained in this graph.
	*/
	@Override
	public Set<Town> vertexSet()
	{
		return towns;
	}
	
	/**
	* A method that returns a set of all edges touching the specified vertex 
	* @param Town : the vertex for which a set of touching edges is to be
	* returned.
	* @return a set of all edges touching the specified vertex.
	* @throws IllegalArgumentException if vertex is not found in the graph.
	* @throws NullPointerException if vertex is null.
	*/
	@Override
	public Set<Road> edgesOf(Town vertex) 
	{
		Set<Road> e = new HashSet<>();
		if (vertex == null)
		{
			throw new NullPointerException();
		}
		if (!containsVertex(vertex))
		{
			throw new IllegalArgumentException();
		}
		for (Road r : roads)
		{
			if (r.getT1().equals(vertex) || r.getT2().equals(vertex))
			{
				e.add(r);
			}
		}
		return e;
	}
	
	/**
	* A method to remove a specified vertex from this graph 
	* @param Town : v vertex to be removed from this graph, if present.
	* @return Boolean : b (true if the graph contained the specified vertex)
	*/
	@Override
	public boolean removeVertex(Town v) 
	{
		Town stored = null;
		for (Town t : towns)
		{
			if (t.equals(v))
			{
				stored = t;
			}
		}
		if (stored != null) 
		{
			towns.remove(stored);
			return true;
		}
		return false;
	}
	
	/**
	* A method to remove an edge
	* @param Town : sourceVertex 
	* @param Town : destinationVertex 
	* @param Int : weight of the edge
	* @param String : description of the edge
	* @return The removed Road
	*/
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) 
	{
		Road stored = new Road(sourceVertex, destinationVertex, weight, description);
		Road returned = null;
		
		for (Road r : roads) 
		{
			if (r.equals(stored))
			{
				returned = r;
				break;
			}
		}
		if (returned != null)
		{
			roads.remove(returned);
		}
		return returned;
	}
	
	/**
	* A method to find the shortest path from the sourceVertex to the destinationVertex
	* @param Town : sourceVertex starting vertex
	* @param Town : destinationVertex ending vertex
	* @return An Arraylist of Strings
	*/
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) 
	{
		ArrayList<String> returned = new ArrayList<>();
		dijkstraShortestPath(sourceVertex);
		Town newTown = destinationVertex;
		
		while (!newTown.equals(sourceVertex)) 
		{
			if (!previousTown.containsKey(newTown.getName())) 
			{
				returned.clear();
				break;
			}
			
			Town parentTown = previousTown.get(newTown.getName());
			Road r = getEdge(parentTown, newTown);
			returned.add(0, parentTown.getName() + " via " + r.getName() + " to " + newTown.getName() + " " + r.getD() + " mi"); 
			newTown = parentTown;
		}
		return returned;
	}
	
	/**
	* Dijkstra's Shortest Path Method.
	* @param Town : sourceVertex the vertex to find shortest path from
	*
	*/
	@Override
	public void dijkstraShortestPath(Town sourceVertex)
	{
			Set<Town> checked = new HashSet<>();
			ArrayList <Town> notVisited = new ArrayList<>();
			HashMap<String, Integer> w = new HashMap<>();
			
			for (Town t : towns) 
			{
				notVisited.add(t);
				w.put(t.getName(), Integer.MAX_VALUE);
				previousTown.put(t.getName(), null);
			}
			
			w.put(sourceVertex.getName(), 0);
			while (!notVisited.isEmpty())
			{
				int lowestCostIndex = 0;
				
				for (int i = 1; i < notVisited.size(); i++) 
				{
					Town unvisitedVertex = notVisited.get(i);
				
					if (w.get(unvisitedVertex.getName()) < w.get(notVisited.get(lowestCostIndex).getName()))
					{
						lowestCostIndex = i;
					}
				}
				
				Town leastw = notVisited.remove(lowestCostIndex);
				checked.add(leastw);
				if (w.get(leastw.getName()) == Integer.MAX_VALUE)
				{
					return; //end of the method
				}

				for (Road r : edgesOf(leastw)) 
				{
					Town next = r.getT2();
					if (next.equals(leastw))
					{
						next = r.getT1();
					}
					
					if (checked.contains(next)) 
					{
						continue; //next case
					}
					
					int adjW = w.get(leastw.getName()) + r.getD();
					
					if (adjW < w.get(next.getName()))
					{
						w.put(next.getName(), adjW);
						previousTown.put(next.getName(), leastw);
					}
				}
			}
	}
}