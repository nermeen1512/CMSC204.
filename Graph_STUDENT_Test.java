

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test
{

	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		  town = new Town[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  graph.addEdge(town[1], town[2], 3, "R1");
		  graph.addEdge(town[1], town[3], 5, "R2");
		  graph.addEdge(town[1], town[5], 7, "R3");
		  graph.addEdge(town[3], town[7], 2, "R4");
		  graph.addEdge(town[3], town[8], 3, "R5");
		  graph.addEdge(town[4], town[8], 4, "R6");
		  graph.addEdge(town[6], town[9], 4, "R7");
		  graph.addEdge(town[9], town[10], 5, "R8");
		  graph.addEdge(town[8], town[10], 3, "R9");
		  graph.addEdge(town[5], town[10], 6, "R10");
		  graph.addEdge(town[10], town[11], 4, "R11");
		  graph.addEdge(town[2], town[11], 7, "R12");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[2], town[11],6, "R12"), graph.getEdge(town[2], town[11]));
		assertEquals(new Road(town[3], town[7],1, "R4"), graph.getEdge(town[3], town[7]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[3], town[5]));
		graph.addEdge(town[3], town[5], 1, "R13");
		assertEquals(true, graph.containsEdge(town[3], town[5]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("T12");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[11]));
		assertEquals(false, graph.containsEdge(town[3], town[5]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_12")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("R1", roadArrayList.get(0));
		assertEquals("R10", roadArrayList.get(1));
		assertEquals("R11", roadArrayList.get(2));
		assertEquals("R12", roadArrayList.get(3));
		assertEquals("R2", roadArrayList.get(4));
		assertEquals("R8", roadArrayList.get(10));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("R1", roadArrayList.get(0));
		assertEquals("R2", roadArrayList.get(1));
		assertEquals("R3", roadArrayList.get(2));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[11]));
		graph.removeEdge(town[2], town[11], 6, "R12");
		assertEquals(false, graph.containsEdge(town[2], town[11]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[10]));
		assertEquals(true, roads.contains(town[11]));
		assertEquals(true, roads.contains(town[2]));
		assertEquals(true, roads.contains(town[3]));
	}

	 @Test
	  public void testTown_1ToTown_11() {
		  String beginTown = "Town_1", endTown = "Town_11";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via R1 to Town_2 3 mi",path.get(0).trim());
			  assertEquals("Town_2 via R12 to Town_11 7 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown1ToTown_10() {
		  String beginTown = "Town_1", endTown = "Town_10";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via R2 to Town_3 5 mi",path.get(0).trim());
			  assertEquals("Town_3 via R5 to Town_8 3 mi",path.get(1).trim());
			  assertEquals("Town_8 via R9 to Town_10 3 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_4ToTown_11() {
		  String beginTown = "Town_4", endTown = "Town_11";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_4 via R6 to Town_8 4 mi",path.get(0).trim());
			  assertEquals("Town_8 via R9 to Town_10 3 mi",path.get(1).trim());
			  assertEquals("Town_10 via R11 to Town_11 4 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
}
